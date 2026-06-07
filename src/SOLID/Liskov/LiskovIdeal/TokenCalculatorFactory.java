package SOLID.Liskov.LiskovIdeal;

/*
Factory: Doğru hesaplayıcıyı seçmek için kullanılan yardımcı factory sınıfı.
 
LSP'nin ikinci kısmı: Interface'leri doğru kullanmak.
Client, ihtiyacına göre doğru interface'i almalı.
Hassas hesaplama lazımsa, ReliableTokenCalculator hız önemli ise ApproximateTokenCalculator

*/
public class TokenCalculatorFactory {

    public static ReliableTokenCalculator createReliableCalculator() {
        return new AccurateTokenCalculator();
    }

    public static ApproximateTokenCalculator createApproximateCalculator() {
        return new FastTokenCalculator();
    }

    public static ReliableTokenCalculator createOfflineCalculator() {
        return new OfflineTokenCalculator();
    }
}
