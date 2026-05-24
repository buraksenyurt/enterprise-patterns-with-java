# Enterprise Pattern and Practices with Java

Bu çalışma alanında Java programlama dili ile **Enterprise Patterns and Practices** konularını ele almaya çalışıyorum. Bu konular, büyük ölçekli uygulamalar geliştirmek için kullanılan tasarım desenleri ve pratikleri içeriyor. Java dilinin temelleri, nesne yönelimli dil felsefesinin Java'da uygulanışı, gerçek hayat senaryolarında sık kullanılan tasarım desenlerinden bazıları, popüler yazılım mimarilerinde öne çıkan önemli pratikler ve Java ekosisteminde yaygın olarak kullanılan araçlar ve çerçeveler gibi konulara odaklanmayı planlıyorum.

## İçerik

- **Fundamentals Projesi:** Bu projede Java dilinin genel özelliklerinin ele alındığı temel bilgiler yer alıyor. Hello World uygulamasında OOP'ın temel ilkelerine ve Java'nın bazı ileri seviye özelliklerine yer veriliyor.

> DETAYLAR ZAMANLA EKLENECEK

## Yardımcı Kaynaklar

- [Java Programming Cheatsheet - Princeton University](https://introcs.cs.princeton.edu/java/11cheatsheet/)

## Ekler

Sonradan konu anlatımlarına eklenebilecek tablo veya diyagramlar için bu bölümü kullanmayı planlıyorum. Bu ekler, konuların daha iyi anlaşılmasına yardımcı olabilir.

### Hello World *(IDE yok Notepad Var)*

IntelliJ IDEA veya VS Code olmadan Notepad gibi basit bir editör ile ilk `Hello World` uygulamasını yazmak ve çıktısını görmek istediğimizde nasıl hareket ederiz? Öncellikle `Program.java` *(İstediğiniz bir ismi verebilirsiniz)* adında bir dosya oluşturur ve içine aşağıdaki kodları yazarız.

```java
import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        System.out.println("Hello there. Today is a great day to learn Java! " + LocalDate.now());
    }
}
```

Ardından kodu **javac** ile derler ve çalıştırırız.

```bash
# derleme
javac Program.java

# ve çalıştırma
java Program

# Java 11 sonrasında gelen JEP 330(Single-File Source-Code Programs) özelliği ile
# javac ile derlemeden de doğrudan kod çalıştırılabilir.
java Program.java
```

### Aggregation vs Composition

Ne zaman hangisi?

| **Özellik**           | **Aggregation *(has-a)***                       | **Composition *(part-of)***                       |
|-------------------|----------------------------------------------|------------------------------------------------|
| Yaşam Döngüsü *(lifecycle)*| İç nesne konteyner nesneden bağımsız olarak varlığını sürdürebilir.|İç nesne konteyner nesne tarafından yönetilir ve onunla birlikte yok edilir.|
| Sahiplik *(ownership)*| Sahiplik zayıftır, iç nesne birden fazla konteyner tarafından paylaşılabilir. Örneğin bir Post nesnesi hem Section hem Tag şeklinde farklı konteynerler tarafından sahiplenilebilir.| Sahiplik güçlüdür, iç nesne yalnızca bir konteyner tarafından sahiplenilir. OrderItem nesnesi veya nesneleri sadece ilişkili olduğu Order nesnesine aittir|
| Nesne yaratımı *(creation)*| Alt nesne dışarıda yaratılır ve konteyner'a parametre ile geçilir| Alt nesne kapsayıcı nesnenin içinde yaratılır|
|Hayal et| Üniveristede bir bölüm kapansa bile öğretim görevlisi kalır| Bir bina yıkıldığında içindeki odalar da yıkılır|
