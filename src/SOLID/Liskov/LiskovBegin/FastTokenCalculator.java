package SOLID.Liskov.LiskovBegin;

/*
Fast Token Calculator - LSP İhlali yapılan sınıf.
 
Problem: "Hızlı hesaplama" için tahmin (approximation) kullanıyor.
Her çağrımda farklı sonuçlar verebilir.
 
Üst sınıf her zaman tutarlı, monotonik sonuç verirken bu sınıf random approximation yaklaşımı nedeniyle tutarsız sonuçlar verir.
Client kodu bozulur ve aynı token sayısı için farklı maliyetler dönebilir.

*/
public class FastTokenCalculator extends TokenCalculator {
    private static final double RATE_PER_TOKEN = 0.002;
    private static final double APPROXIMATION_ERROR = 0.3; // + veya - %30 hata

    /*
    LSP ihlali: tahmin hesaplama, her seferde farklı sonuç!
     
    Beklenti: hesaplama tutarlı olsun
    Gerçek: approximation random hata ekliyor
    
    */
    @Override
    public double calculateCost(long tokens) {
        double baseCost = tokens * RATE_PER_TOKEN;

        // Random approximation - her çağrışta farklı sonuç!
        double randomError = (Math.random() - 0.5) * 2 * APPROXIMATION_ERROR;
        double approximation = baseCost * (1 + randomError);

        // Bir de logaritmik approximation yapıyor - mantık bozuk
        if (tokens > 10000) {
            approximation = baseCost * 0.5; // Büyük token'lar için başka bir hata
        }

        return Math.max(0, approximation);
    }
}
