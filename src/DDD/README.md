# Spring Boot ile Basit bir DDD Projesi

Domain Driven Design (DDD) temellerinin Spring Boot kullanarak ele alındığı giriş seviyesinde bir Web API projesi. DDD'yi karmaşık bir seviyede ele almayacağız. Yani CQRS *(Command Query Responsibility Segregation)*, Event Sourcing, Message Bus gibi kavramlara bu projede girmeyeceğiz. BUnun yerine ubiquitous language, value objects, entities, aggregates, repositories, clean layering gibi kavramlara odaklanıp Java programlama dilinin nesne yönelimli özelliklerini sahada deneyimlemeye çalışacağız.

## Senaryo

Bilgisayar oyunu kiralayabildiğimiz bir sistemin backend tarafını geliştireceğiz. En basit haliyle Ubiquitous Language'ı tanımlayarak başlayalım:

- Oyuunlar kataloğumuzda birer isim *(Pacman, Super Mario,...)* gibi. Mağazamızda oyun kutularından n adet olabilir.
- Abonelerimiz var. Bu demoda aboneleri sadece bir ID olarak tanımlayacağız.
- Abonelerimiz oyun kiralayabilirler. Kiralanan oyunlar belli bir sürede geri getirilir yani kiralama süreleri vardır.
- Abone kiraladığı oyunu geri getirdiğinde kiralama sona erer ve oyun tekrar mağazada kiralanabilir hale gelir. Ama gecikme olursa bu gecikme süresi kadar ekstra ücret ödenir. Örneğin gecikilen gün başına 1 TL gibi.

İş kuralarımız ile bazı şeyleri güvence altına alalım:

- Mağaza stoğunda olmayan bir oyun kiralanamaz.
- Oyun kiralandığında kullanılabilir oyun sayısı 1 azalır, geri getirildiğinde 1 artar.
- Bir kiralama iki kez geri getirilemez.
- Gecikme ücreti için şu formül geçerlidir: `gecikme ücreti = gecikilen gün sayısı * 1 TL`

Buradaki basit iş kuralları Domain model içerisinde yaşayacak ve asla atlanamayacaktır *(No Bypass)*. Bu sayede iş kurallarımızın her zaman geçerli olduğunu garanti altına alacağız.

## DDD Özeti

DDD daha çok iş modelini kodun tam merkezine yerleştirme yaklaşımıdır. Bu sayede iş kuralları ve mantığı, uygulamanın her yerinde tutarlı bir şekilde uygulanabilir. Ayrıca framework, veritabanı gibi altyapı detaylarını dışarıda tutarak, iş modelinin bağımsız ve test edilebilir olmasını sağlar. Bu örnek özelinde ele alacağımız kavramları aşağıdaki tablo ile özetleyebiliriz...

| **Kavram** | **Ne anlama gelir?** | **Bizim örneğimizde neye karşılık gelir?** |
| --- | --- | --- |
| **Ubiquitous Language** | Tüm ekip *(Geliştiriciler, İş Analistleri, Test Uzmanları, vb.)* tarafından paylaşılan ortak dil. | Game, Rental, lateFee, returnOn vb |
| **Value Object** | Kimliği olmayan, sadece değerleriyle tanımlanan nesneler. Değiştirilemezdirler. *(Immutable)* | Money, GameId gibi |
| **Entity** | Kimliği olan, yaşam döngüsü boyunca değişebilen nesneler. | Game, Rental gibi |
| **Aggregate** | Birbirleriyle ilişkili Entity ve Value Object'lerin bir araya gelerek oluşturduğu tutarlı bir bütün. | RentalAggregate, GameAggregate gibi |
| **Aggregate Root** | Aggregate'in dış dünya ile olan tek giriş noktasıdır. | RentalAggregate'in root'u Rental, GameAggregate'in root'u Game gibi |
| **Repository** | Aggregate'lerin saklanması ve erişilmesi için kullanılan koleksiyon benzeri aggregate yapıları. | RentalRepository, GameRepository gibi |
| **Domain Service** | Birden fazla Entity veya Value Object'in etkileşimde bulunduğu karmaşık iş mantığını içeren servisler. | Bu örnekte ele almayacağız |
| **Application Service** | Bir transaction *(Use Case)* orkestrasyonunu yöneten servis. | RentGameService |

## Proje Mimarisi

Projede oldukça yalın katmanlı *(layered)* mimari kullanacağız. Yapıyı hexagonal mimari türünde inşa edeceğiz. Burada altın kural bağımlılıkların yönünün *(Dependency Direction)* doğru uygulanması. Örneğin domain paketi sıfır framework bağımlılığına sahip olmalı ki domain modelindeki iş kurallarını çok kısa sürelerde hiçbir dış framework bağımlılığı olmadan test edebilelim. Bu sayede domain modelimizi daha esnek ve sürdürülebilir hale getireceğiz. Mimari kurguyu kabaca aşağıdaki şekilde olduğu gibi özetleyebiliriz.

![DDD Basic](../../images/DDDBasic.png)

## Proje İskeletinin Oluşturulması

Spring Boot proje oluşturma aracı olan [Spring Initializr](https://start.spring.io/) adresini kullanarak projemizi oluşturabiliriz. İster web sitesinden ister **curl** komutu ile oluşturabiliriz.

![Spring Boot Initializr](../../images/SpringBootInit.png)

Özellikle kendi sistemimizde hangi Java ve Maven versiyonları olduğuna dikkat etmekte yarar var. Aynı işlemi terminal üzerinden de yapabiliriz.

```bash
curl https://start.spring.io/starter.zip \
  -d type=maven-project \
  -d language=java \
  -d bootVersion=3.5.15 \
  -d javaVersion=25 \
  -d groupId=com.example \
  -d artifactId=game-rental \
  -d name=game-rental \
  -d packageName=com.example.gamerental \
  -d dependencies=web,data-jpa,postgresql,validation,flyway \
  -o game-rental.zip

unzip game-rental.zip -d game-rental
cd game-rental
```

Dikkat edileceği üzere proje oluşturulurken bazı bağımlılıklar eklenmiş durumda *(dependencies)*. Bunları şöyle özetleyebiliriz.

| **Bağımlılık** | **Ne işe yarar?** |
| --- | --- |
| **Spring Web** | REST API geliştirmek için gerekli olan Spring MVC altyapısını sağlar. Tomcat gibi gömülü bir web sunucusu içerir. |
| **Spring Data JPA** | ORM *(Object-Relational Mapping)* işlemleri için gerekli altyapıyı sağlar. JPA standartlarını kullanarak veritabanı işlemlerini kolaylaştırır. |
| **PostgreSQL Driver** | PostgreSQL veritabanına bağlanmak için gerekli sürücüyü sağlar. |
| **Spring Validation** | Bean Validation API'sini kullanarak veri doğrulama işlemlerini kolaylaştırır. |
| **Flyway** | Veritabanı şemasını yönetmek ve sürüm kontrolü sağlamak için kullanılan bir araçtır. Migrations işlemlerini kolaylaştırır. |

> Örnekte postgresql veritabanı kullanılmakta olup **docker-compose** ile ayağa kaldırılmaktadır.
