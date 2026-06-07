package SOLID.OpenClosedBegin;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        demonstrateOcpViolation();
    }

    private static void demonstrateOcpViolation() {
        System.out.println("Open/Close prensibinin ihlal edildiği örnek:");
        System.out.println("Lütfen kodları inceleyin...");

        setupTestContexts();

        // Claude: Premium abonelik fiyatlandırması
        System.out.println("1. Claude (Premium LLM)");
        ClaudeSubscriber claude = new ClaudeSubscriber();
        claude.setSubscriberId(1001L);
        claude.setFullName("Alice Pro");
        claude.setSubscriptionTier("pro");
        displayCredit("Claude Pro", claude.calculateAiCredit());

        claude.setSubscriptionTier("standard");
        displayCredit("Claude Standard", claude.calculateAiCredit());
        System.out.println();

        // Grok: Bütçe dostu abonelik fiyatlandırması
        System.out.println("2. Grok (Budget LLM)");
        GrokSubscriber grok = new GrokSubscriber();
        grok.setSubscriberId(1002L);
        grok.setFullName("Bob Budget");
        grok.setSubscriptionTier("plus");
        grok.setDiscountPercent(0);
        displayCredit("Grok Plus (no discount)", grok.calculateAiCredit());

        grok.setDiscountPercent(15);
        displayCredit("Grok Plus (15% discount)", grok.calculateAiCredit());
        System.out.println();

        // Llama: Topluluk modeli ve toplu iş bonusu
        System.out.println("3. Llama (Open-source LLM)");
        LlamaSubscriber llama = new LlamaSubscriber();
        llama.setSubscriberId(1003L);
        llama.setFullName("Charlie Community");
        llama.setBatchProcessingEnabled(false);
        displayCredit("Llama (batch disabled)", llama.calculateAiCredit());

        llama.setBatchProcessingEnabled(true);
        displayCredit("Llama (batch enabled: +5%)", llama.calculateAiCredit());
        System.out.println();
    }

    private static void setupTestContexts() {
        // Her abonelik için 3 oturum ve farklı token sayıları ekleyelim
        long[][] testData = {
            {1001L, 5000L},  // Claude session 1: 5k tokens
            {1001L, 8000L},  // Claude session 2: 8k tokens
            {1001L, 3000L},  // Claude session 3: 3k tokens
            {1002L, 10000L}, // Grok session 1: 10k tokens
            {1002L, 7000L},  // Grok session 2: 7k tokens
            {1002L, 6000L},  // Grok session 3: 6k tokens
            {1003L, 20000L}, // Llama session 1: 20k tokens
            {1003L, 15000L}, // Llama session 2: 15k tokens
            {1003L, 12000L}  // Llama session 3: 12k tokens
        };

        for (long[] data : testData) {
            SessionHistory.addContext(
                data[0],
                LocalDateTime.now(),
                data[1]
            );
        }
    }

    private static void displayCredit(String model, double credit) {
        System.out.printf("  %s: %.4f AI Credits\n", model, credit);
    }
}

