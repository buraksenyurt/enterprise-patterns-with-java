package SOLID.Liskov.LiskovBegin;

/**
 * Liskov Substitution Principle İhlali
 * 
 * LSP Tanım:
 * 
 * "Türetilmiş(derived) sınıflar, türediği temel(base) sınıfların yerini
 * tam olarak alabilmelidir. Yani, T tipi yerine S tipi kullanıldığında
 * programın doğruluğu bozulmamalıdır."
 * 
 * Senaryo: Token maliyet hesaplaması - 3 farklı hesaplayıcı:
 * 
 * AccurateTokenCalculator: LSP'yi doğru karşılıyor.
 * FastTokenCalculator: Tutarsız değerler üreterek LSP İhlalini simüle ediyor
 * OfflineTokenCalculator: Exception throw ederek LSP İhlalini simüle ediyor
 */
public class Main {
    public static void main(String[] args) {
        demonstrateLiskovViolation();
    }

    private static void demonstrateLiskovViolation() {
        System.out.println("Liskov Substitution Principle ihlalleri içeren örnek.\n");

        // Test parametreleri
        long[] testTokens = { 1000L, 5000L, 15000L };

        System.out.println("1. AccurateTokenCalculator (LSP uyumlu)");
        TokenCalculator accurate = new AccurateTokenCalculator();
        testCalculator(accurate, testTokens);
        System.out.println();

        System.out.println("2. FastTokenCalculator (LSP ihlal tutarsız)");
        testFastCalculatorInconsistency();
        System.out.println();

        System.out.println("3. OfflineTokenCalculator (LSP ihlal - Exception)");
        testOfflineCalculatorException();
        System.out.println();

        System.out.println("4. Polymorphic kullanım - Tüm hesaplayıcılar TokenCalculator referansıyla:");
        testPolymorphicSubstitution();
    }

    private static void testCalculator(TokenCalculator calc, long[] testTokens) {
        for (long tokens : testTokens) {
            double cost = calc.calculateCost(tokens);
            System.out.printf("  %7d token → %.4f AI Credit\n", tokens, cost);
        }
    }

    private static void testFastCalculatorInconsistency() {
        TokenCalculator fast = new FastTokenCalculator();
        long tokens = 5000L;

        for (int i = 1; i <= 5; i++) {
            double cost1 = fast.calculateCost(tokens);
            double cost2 = fast.calculateCost(tokens);

            System.out.printf("\tÇağrı %d: %.4f vs %.4f %s\n",
                    i, cost1, cost2, cost1 != cost2 ? "Farklı sonuçlar!" : "");
        }

        System.out.println();
    }

    private static void testOfflineCalculatorException() {
        TokenCalculator offline = new OfflineTokenCalculator();
        long tokens = 1000L;

        System.out.println("\tOffline hesaplayıcıyı kullan:");
        try {
            double cost = offline.calculateCost(tokens);
            System.out.printf("\tMaliyet: %.4f AI Credit\n", cost);
        } catch (UnsupportedOperationException e) {
            System.out.println("\tException throw: " + e.getMessage());
            System.out.println();
        }
    }

    private static void testPolymorphicSubstitution() {
        TokenCalculator[] calculators = {
                new AccurateTokenCalculator(),
                new FastTokenCalculator(),
                new OfflineTokenCalculator()
        };

        long tokens = 1000L;

        System.out.println("Tüm hesaplayıcılar TokenCalculator aracılığıyla:");
        for (TokenCalculator calc : calculators) {
            try {
                double cost = calc.calculateCost(tokens);
                System.out.printf("\t%s: %.4f AI Credit\n",
                        calc.getClass().getSimpleName(), cost);
            } catch (Exception e) {
                System.out.printf("\t%s:Exception: %s\n",
                        calc.getClass().getSimpleName(), e.getMessage());
            }
        }
    }
}
