package SOLID.Liskov.LiskovBegin;

/*

Accurate Token Calculator - LSP ilkesini doğru şekilde uygulayan örnektir.
 
TokenCalculator'ın sözleşmesini tam olarak yerine getirir. Öyle ki;
Her zaman geçerli bir sonuç döner. Örneğin negatif değer dönemez.
Token arttıkça maliyet artar.

*/
public class AccurateTokenCalculator extends TokenCalculator {
    private static final double RATE_PER_TOKEN = 0.002;
    
    /*
    Tam hesaplama: tokens × rate
    Sözleşme: her zaman geçerli, tutarlı sonuç döner
    */
    @Override
    public double calculateCost(long tokens) {
        return tokens * RATE_PER_TOKEN;
    }
}
