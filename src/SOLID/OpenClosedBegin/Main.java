package SOLID.OpenClosedBegin;

import SOLID.OpenClosedCommon.Utility;

public class Main {
    public static void main(String[] args) {
        demonstrateOcpViolation();
    }

    private static void demonstrateOcpViolation() {
        System.out.println("Open/Close prensibinin ihlal edildiği örnek:");
        System.out.println("Lütfen kodları inceleyin...");

        // Test verisi ekleyelim
        Utility.setupTestContexts();

        // Claude: Premium abonelik fiyatlandırması
        System.out.println("1. Claude (Premium LLM)");
        ClaudeSubscriber claude = new ClaudeSubscriber();
        claude.setSubscriberId(1001L);
        claude.setFullName("Alice Pro");
        claude.setSubscriptionTier("pro");
        Utility.displayCredit("Claude Pro", claude.calculateAiCredit());

        claude.setSubscriptionTier("standard");
        Utility.displayCredit("Claude Standard", claude.calculateAiCredit());
        System.out.println();

        // Grok: Bütçe dostu abonelik fiyatlandırması
        System.out.println("2. Grok (Budget LLM)");
        GrokSubscriber grok = new GrokSubscriber();
        grok.setSubscriberId(1002L);
        grok.setFullName("Bob Budget");
        grok.setSubscriptionTier("plus");
        grok.setDiscountPercent(0);
        Utility.displayCredit("Grok Plus (no discount)", grok.calculateAiCredit());

        grok.setDiscountPercent(15);
        Utility.displayCredit("Grok Plus (15% discount)", grok.calculateAiCredit());
        System.out.println();

        // Llama: Topluluk modeli ve toplu iş bonusu
        System.out.println("3. Llama (Open-source LLM)");
        LlamaSubscriber llama = new LlamaSubscriber();
        llama.setSubscriberId(1003L);
        llama.setFullName("Charlie Community");
        llama.setBatchProcessingEnabled(false);
        Utility.displayCredit("Llama (batch disabled)", llama.calculateAiCredit());

        llama.setBatchProcessingEnabled(true);
        Utility.displayCredit("Llama (batch enabled: +5%)", llama.calculateAiCredit());
        System.out.println();
    }
}
