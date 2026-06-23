# Kurumsal Çözümler (Enterprise Solutions) için Java

Kurumsal projeleri düşündüğümüzde hepsinin belli başlı temel ve aynı zamanda ortak ihtiyaçları olduğunu görürüz. Veri saklama *(Persistence)*, güvenlik *(Security)*, web servisleri *(Web Services)*, transaction yönetimi, gevşek bağlı yapılar *(Loose Coupling)* vb Bu değişmeyen ihtiyaçlarda soyutlamaların *(Abstraction)* standartlaştırılması da önemlidir. Asıl implementasyon detayları bu soyutlamaların üzerinde şekillenir. Ana prensip olarak Java Enterprise Edition (Java EE) veya Jakarta EE gibi çatılar bu soyutlamaları standartlaştırmak için ortaya çıkmıştır.

Bu noktada bazı temel kavramları bilmekte yarar var.

## Application Server

Örneğin uygulama sunucları *(Application Server)* kurumsal çözümlerin önemli bir parçasıdır. Loglama, hata yönetimi, REST uç noktaları, JSON standartları, CDI *(Contexts and Dependency Injection)*, JPA *(Java Persistence API)*, JMS *(Java Message Service)*, EJB *(Enterprise Java Beans)* gibi kurumsal çözümlerde sıkça ihtiyaç duyulan soyutlamaları standartlaştırırlar. Bu sayede geliştiriciler uygulama sunucusunun sağladığı standartları kullanarak iş mantığını geliştirmeye odaklanabilirler. Bazı popüler uygulama sunucuları şunlardır:

- [IBM Open Liberty](https://openliberty.io/)
- [Payara Server *(Glassfish)*](https://www.payara.fish/)
- [JBOSS Wildfly](https://www.wildfly.org/)

Bu sunucular bir nevi Java EE spesifikasyonlarının asıl implementasyonları *(Concrete Implementations)* olarak düşünülebilir. Örneğin Jakarta EE 11 spesifikasyonları için Open Liberty, Payara Server ve Wildfly gibi uygulama sunucuları asıl implementasyonları sağlarlar.

## JSR *(Java Specification Request)*

JSR, Java topluluğu tarafından önerilen ve Java platformuna eklenmesi düşünülen yeni özellikleri veya mevcut özelliklerde yapılacak değişiklikleri tanımlayan bir belgedir. Her JSR, belirli bir Java teknolojisi veya API için bir spesifikasyon sunar ve bu spesifikasyonlar, uygulama sunucuları tarafından implemente edilir. Örneğin [CDI 1.0 için JSR-299](https://jcp.org/ja/jsr/detail?id=299), [JPA 2.0 için JSR-317](https://jcp.org/ja/jsr/detail?id=317) gibi

## Reference Implementation *(RI)*

Özet JSR'ların *(Abstract Specifications)* asıl implementasyonlarıdır. Örneğin JAX-RS için referans implementasyon olarak [Jersey](https://eclipse-ee4j.github.io/jersey/) kullanılabilir. Hatta Java EE'ın kendisi aslında bir JSR *(Java Specification Request)* olarak düşünülebilir. Java EE 8 sürümü [JSR 366](https://jcp.org/en/jsr/detail?id=366) olarak tanımlanmıştır ve Glassfish bu JSR'ın örnek bir implementasyonudur *(RI - Reference Implementation)*.

## Jakarta EE

[Jakarta EE](https://jakarta.ee/) Java EE'ın evrimleşmiş bir versiyonu olarak düşünülebilir. Oracle'ın Java EE'yi Eclipse Foundation'a devretmesiyle birlikte, Java EE artık Jakarta EE olarak adlandırılmaktadır. Jakarta EE, Java EE'ın tüm özelliklerini ve API'lerini içerir, ancak isimlendirme ve bazı paket değişiklikleri ile güncellenmiştir. Örneğin, `javax.*` paketleri artık `jakarta.*` olarak değişmiştir.

## Alet Çantası

Nelere ihtiyacımız var?

- JDK *(Java Development Kit)*
- [NetBeans IDE](https://netbeans.apache.org/front/main/index.html), [Eclipse IDE](https://www.eclipse.org/downloads/) veya [Visual Studio Code](https://code.visualstudio.com/) gibi kod geliştirme aracı.
- [Insomnia](https://insomnia.rest/) veya [Postman](https://www.postman.com/) gibi REST API test araçları.
- [Apache Maven](https://maven.apache.org/) veya [Gradle](https://gradle.org/) gibi proje yönetim ve derleme araçları.
- [Payara Micro Server](https://payara.fish/products/payara-micro/) Micro service suncusu olarak kullanabiliriz. Hafifsiklet bir web sunucusu olarak düşünebiliriz.

Kendi Ubuntu sistemimde `Insomnia` kurulumunda sorun çıktı. Aşağıdaki şekilde kurabildim.

```bash
wget --content-disposition https://updates.insomnia.rest/downloads/ubuntu/latest
sudo apt install ./Insomnia*.deb
```

Benzer şekilde `Payara Micro` sunucusunu çalıştırırken de IPv6 ile ilgili bir hata aldım. Burada IPv4 kullanmak için aşağıdaki komutu kullanabilirsiniz.

```bash
# Payara Micro 7.2026.5.jar içeriğini indirdiğim klasörde çalıştırıyorum.
java -Djava.net.preferIPv4Stack=true -jar payara-micro-7.2026.5.jar
# Sonrasında 8080 portu üzerinden sunucuya erişebilirsiniz.
```

## Hello World Uygulaması

Macera Jakarta öncesi dönemden EE 8 uyumlu bir proje ile başlıyor. Bu projeyi oluşturmak için NetBeans IDE kullanabiliriz. NetBeans IDE'yi açtıktan sonra aşağıdaki adımları takip edebiliriz.

- Adım 1 Proje seçimi: File -> New Project -> Java with Maven -> Project from Archetype -> Next
- Adım 2 Archetype seçimi: `jakarta.jakartaee-api` seçimi -> Next
- Adım 3 Proje bilgileri: Project Name : `hello-world`, Group Id olarak `lecture.java` verip projeyi oluşturabiliriz.

`HelloResources.java` içeriğini olduğu gibi bırakabiliriz.

```java
package jp.coppermine.ping;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * Sample JAX-RS resources.
 *
 */
@Path("hello")
@RequestScoped
public class HelloResource {
    
    @GET
    public String getMessage() {
        return "Hello, world";
    }
    
}
```

Sonrasında projeye sağ tıklayıp `Clean and Build` ile temiz bir derleme başlatalım. Bu işlem sonraında projenin `target` isimli klasöründe `hello-world.war` isimli bir dosya oluşacaktır *(WAR' ın açılımı Web Application Resource ya da Web application ARchive)*. Bu dosya web uygulamasının paketlenmiş halidir. Bunu bir web sunucusuna deploy ederek çalıştırabiliriz. Örneğin Payara Micro sunucusu üzerinde.

Kendi ubuntu sistemimde şöyle hareket ettim; Payara Micro sunucusu indirdiğim klasörde `wars` isimli bir alt klasör açtım ve projenin derlenmiş `hello-world.war` dosyasını buraya kopyaladım. Root klasörde ise aşağıdaki komutu işlettim.

```bash
java -Djava.net.preferIPv4Stack=true -jar payara-micro-7.2026.5.jar --deploy wars/hello-world.war
```

Bu komut `hello-world.war` dosyasını deploy ederek sunucuyu başlatacaktır. Sonrasında `http://localhost:8080/hello-world/api/hello` adresine gittiğimizde tarayıcıda aşağıdaki çıktıyı görebiliriz.

![jakarta-hello](../../images/JakartaHelloWorld.png)

## FAQ

- **Java EE denince aklımıza ne gelmeli?** Kurumsal çözümler geliştirmek için kullanılan bir özet spesifikasyonlar *(Abstract Specifications)* ve standartlar koleksiyonu.
- **Neden Jakarta EE diye de bir şey var?** Oracle'ın Java EE'yi Eclipse Foundation'a devretmesiyle birlikte, Java EE artık Jakarta EE olarak adlandırılmaktadır. Jakarta EE, Java EE'ın tüm özelliklerini ve API'lerini içerir, ancak isimlendirme ve bazı paket değişiklikleri ile güncellenmiştir.
- **Peki ya Jakarta EE ile Spring Framework arasındaki farklar nelerdir?** Java EE, Spring Framework'ten etkilenmiştir ve Spring boot'ta Java EE'den etkilenmiştir. Her ikisi de iyi platformlardır ve bir karşılaştırma yapmak gereksizdir.
- **JSR Kıslatmasını görünce ne anlamalıyız?** Java topluluğu tarafından önerilen ve Java platformuna eklenmesi düşünülen yeni özellikleri veya mevcut özelliklerde yapılacak değişiklikleri tanımlayan bir belge. Her JSR, belirli bir Java teknolojisi veya API için bir spesifikasyon sunar ve bu spesifikasyonlar, uygulama sunucuları tarafından implemente edilir. Örneğin [CDI 1.0 için JSR-299](https://jcp.org/ja/jsr/detail?id=299), [JPA 2.0 için JSR-317](https://jcp.org/ja/jsr/detail?id=317) gibi
