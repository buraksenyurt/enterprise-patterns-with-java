package SOLID.Liskov.LiskovIdeal;

/**
 * Liskov Substitution Principle ilkesinin doğru uygulanması için ideal bir örnek.
 * 
 * Bu örnekte biraz daha fazla efor var. Token maliyetlerini tam tutarlı olarak hesap etmek,
 * duruma göre hızlı ama yaklaşık sonuçlar veren bir versiyonunu kullanmak veya offline olma halinde
 * güvenli bir fallback mekanizması sağlamak gibi farklı senaryoları ele alıyoruz.
 * 
 * Dolayısıyla birkaç şeyi ele almak gerekiyor.
 * 
 * Role-based interface separation: ReliableTokenCalculator ve ApproximateTokenCalculator
 * Semantic kontrat: Her interface açıkça kendi sözleşmesini tanımlamalı
 * Deterministic davranış: Aynı input için aynı output alınmalı.
 * Exception handling: Exception throw edilmemeli.
 * Factory pattern: Doğru calculator seçimi için bir factory sınıfı gerekli
 */
public class Main {
    public static void main(String[] args) {
        demonstrateLiskovCompliance();
    }
    
    private static void demonstrateLiskovCompliance() {
        System.out.println("Liskov Substitution Principle - İdeal Uygulama");
        
        long[] testTokens = {1000L, 5000L, 15000L};
        
        System.out.println("1. ReliableTokenCalculator (LSP uyumlu)");
        ReliableTokenCalculator reliable = TokenCalculatorFactory.createReliableCalculator();
        System.out.println("(Deterministic, Exception-free)");
        testReliableCalculator(reliable, testTokens);
        System.out.println();
        
        System.out.println("2. ApproximateTokenCalculator (LSP uyumlu)");
        ApproximateTokenCalculator approximate = TokenCalculatorFactory.createApproximateCalculator();
        System.out.printf("(Hızlı, + veya - %.1f%% hata, deterministic)\n", approximate.getApproximationError() * 100);
        testApproximateCalculator(approximate, testTokens);
        System.out.println();
        
        System.out.println("3. OfflineTokenCalculator (LSP uyumlu)");
        OfflineTokenCalculator offline = (OfflineTokenCalculator) TokenCalculatorFactory.createOfflineCalculator();
        System.out.println("(Offline-tolerant, güvenli fallback)");
        testOfflineCalculator(offline, testTokens);
        System.out.println();
        
        System.out.println("4. Determinism Test (LSP uyumu)");
        testDeterminism();
        System.out.println();
        
        System.out.println("5. Polymorphic Usage (LSP uyumlu)");
        testPolymorphicUsage();
    }

    private static void testReliableCalculator(ReliableTokenCalculator calc, long[] tokens) {
        for (long t : tokens) {
            double cost = calc.calculateCost(t);
            System.out.printf("  %7d token -> %.4f AI Credit\n", t, cost);
        }
    }

    private static void testApproximateCalculator(ApproximateTokenCalculator calc, long[] tokens) {
        for (long t : tokens) {
            double cost = calc.calculateCost(t);
            double reliable = t * 0.002;
            double error = Math.abs(cost - reliable);
            System.out.printf("  %7d token -> %.4f AI Credit (±%.2f error)\n", t, cost, error);
        }
    }
    
    private static void testOfflineCalculator(OfflineTokenCalculator calc, long[] tokens) {
        System.out.println("\tDurum: Offline");
        for (long t : tokens) {
            double cost = calc.calculateCost(t);
            System.out.printf("\t\t%7d token -> %.4f AI Credit (fallback: 0)\n", t, cost);
        }
        
        System.out.println("\tBağlantı kuruluyor...");
        calc.connect();
        System.out.println("\tDurum: Online");
        
        for (long t : tokens) {
            double cost = calc.calculateCost(t);
            System.out.printf("\t\t%7d token -> %.4f AI Credit (gerçek hesaplama)\n", t, cost);
        }
    }
    
    private static void testDeterminism() {
        ReliableTokenCalculator reliable = TokenCalculatorFactory.createReliableCalculator();
        ApproximateTokenCalculator approximate = TokenCalculatorFactory.createApproximateCalculator();
        
        long tokens = 5000L;
        
        System.out.println("\tAynı 5000 token'ı 5 kere hesapla:");
        
        System.out.println("\tReliable Calculator:");
        for (int i = 1; i <= 3; i++) {
            double c1 = reliable.calculateCost(tokens);
            double c2 = reliable.calculateCost(tokens);
            String result = c1 == c2 ? "Aynı (deterministic)" : "Farklı (LSP ihlali!)";
            System.out.printf("\t\tÇağrı %d: %.4f vs %.4f %s\n", i, c1, c2, result);
        }
        
        // Approximate test
        System.out.println("\tApproximate Calculator:");
        for (int i = 1; i <= 3; i++) {
            double c1 = approximate.calculateCost(tokens);
            double c2 = approximate.calculateCost(tokens);
            String result = c1 == c2 ? "Aynı (deterministic)" : "Farklı (LSP ihlali!)";
            System.out.printf("\t\tÇağrı %d: %.4f vs %.4f %s\n", i, c1, c2, result);
        }
    }
    
    private static void testPolymorphicUsage() {
        long tokens = 10000L;
        
        System.out.println("\tUse Case 1: Fatura Hazırlama (Reliable gerekli)");
        ReliableTokenCalculator reliable = TokenCalculatorFactory.createReliableCalculator();
        double billingCost = reliable.calculateCost(tokens);
        System.out.printf("\t\tFatura: %.4f AI Credit (tam doğru)\n", billingCost);
        
        System.out.println("\tUse Case 2: UI Preview (Approximate yeterli)");
        ApproximateTokenCalculator approximate = TokenCalculatorFactory.createApproximateCalculator();
        double estimateCost = approximate.calculateCost(tokens);
        System.out.printf("\t\tTahmin: %.4f AI Credit (+ veya - %.1f%% hata kabul)\n", 
            estimateCost, approximate.getApproximationError() * 100);
    }
}

