package SOLID.Liskov.Begin;

/*
Liskov Substitution Principle ihlalinin gösterildiği örnek.
 
LSP: Türetilmiş sınıflar (subclass) türedikleri temel sınıfların (superclass)
yerini tam olarak alabilmelidir. Alt sınıfın davranışı üst sınıfın
sözleşmesini(contract) ihlal etmemelidir.

Senaryomuz yine bir token maliyet hesaplaması üzerine.
 
Sözleşmenin vaat ettiği garantiler ise şöyle:
- Her zaman geçerli bir AI Credit hesaplaması dön
- Negatif değer dönme
- Token sayısı arttıkça maliyet artmalıdır (monotonik)

*/
public abstract class TokenCalculator {

    /*   
    Verilen token sayısına göre AI Credit maliyetini hesapla.
     
    Kontrat (Contract):
     
    tokens: 0 veya pozitif sayı
    Dönüş değeri: her zaman >= 0 ve <= tokens * maksimumRate
    Exception: hiçbir zaman throw etmez
    */
    public abstract double calculateCost(long tokens);
}
