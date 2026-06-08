package SOLID.Liskov.Begin;

/*
Offline Token Calculator - LSP ihlali yapılan bir diğer sınıf.

Problem: Çalışamayan bir hesaplayıcı söz konusu.
Bunu göstermek için her çağrışta UnsupportedOperationException throw ediyoruz.
 
Liskov Substitution Principle ihlali:
 
Aslında üst sınıf hiçbir zaman exception throw etmez (kontrat) Oysaki bu sınıf 
senaryo göre her zaman exception döndürüyor. Client kodu runtime error alacağından
TokenCalculator yerine kullanılamaz (substitutable-yerine kullanılabilirlik ihlali)

*/
public class OfflineTokenCalculator extends TokenCalculator {
    
    private boolean isConnected = false;
    
    public OfflineTokenCalculator() {
        // Olayı dramatize etmek için bağlantı yokmuş gibi davranıyoruz
        this.isConnected = false;
    }
    
    /*
    LSP ihlali: Exception throw ediyor!
     
    Üst sınıf kontratına göre "Exception atma, her zaman sonuç dön" deniyor.
    Ama gerçekte olan UnsupportedOperationException
    */
    @Override
    public double calculateCost(long tokens) {
        if (!isConnected) {
            // Temel sınıf bu durumu öngörmüyor/garanti etmiyor
            throw new UnsupportedOperationException(
                "Offline modu: Token hesaplama hizmeti kullanılamıyor. " +
                "Lütfen internet bağlantısını kontrol edin."
            );
        }
        
        // Hiç çalışmayan kod
        return 0;
    }
    
    // Bağlantı kurulur ama arkadaş çalışmıyor
    public void connect() {
        // Fake connection.
        this.isConnected = true;
        // Ama hala calculateCost() çalışmıyor
    }
}
