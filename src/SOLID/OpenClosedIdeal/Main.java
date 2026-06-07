package SOLID.OpenClosedIdeal;

import java.util.ArrayList;
import java.util.List;
import SOLID.OpenClosedCommon.Utility;

/**
 * OpenClosedIdeal: OCP (Open/Closed Principle) DOĞRU uygulaması
 * 
 * Fark: OpenClosedBegin'de her LLM'in kendi sınıfı vardı ve Main değişmesi
 * gerekliydi.
 * Burada: Abstract Subscriber + Polymorphism = yeni LLM eklemek = sadece yeni
 * sınıf.
 * Main HIÇBIR değişikliğe ihtiyaç duymaz.
 */
public class Main {
    public static void main(String[] args) {
        demonstrateOcpCompliance();
    }

    /**
     * OCP'nin doğru uygulamasını gösterir.
     * Yeni bir LLM eklemek için Main'i değiştirmemize gerek yoktur, sadece yeni bir
     * Subscriber sınıfı ekleriz.
     */
    private static void demonstrateOcpCompliance() {
        System.out.println("Open/Closed prensibinin doğru uygulandığı örnek:");
        System.out.println("Polymorphism kullanarak yeni LLM'ler kolayca eklenebilir.");
        System.out.println("Detaylar için lütfen kodları inceleyin...");

        Utility.setupTestContexts();

        // Tüm LLM'leri Subscriber referansıyla depolayabiliriz - Burada polymorphism
        // kullanıyoruz!
        List<Subscriber> subscribers = new ArrayList<>();

        // Claude: Premium abonelik fiyatlandırması
        System.out.println("1. Claude (Premium LLM)");
        ClaudeSubscriber claude = new ClaudeSubscriber();
        claude.setSubscriberId(1001L);
        claude.setFullName("Alice Pro");
        claude.setSubscriptionTier("pro");
        subscribers.add(claude);
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
        subscribers.add(grok);
        Utility.displayCredit("Grok Plus (indirim yok)", grok.calculateAiCredit());

        grok.setDiscountPercent(15);
        Utility.displayCredit("Grok Plus (%15 indirim)", grok.calculateAiCredit());
        System.out.println();

        // Llama: Topluluk modeli ve toplu iş bonusu
        System.out.println("3. Llama (Açık Kaynak LLM)");
        LlamaSubscriber llama = new LlamaSubscriber();
        llama.setSubscriberId(1003L);
        llama.setFullName("Charlie Community");
        llama.setBatchProcessingEnabled(false);
        subscribers.add(llama);
        Utility.displayCredit("Llama (toplu işlem kapalı)", llama.calculateAiCredit());

        llama.setBatchProcessingEnabled(true);
        Utility.displayCredit("Llama (toplu işlem açık: +%5)", llama.calculateAiCredit());
        System.out.println();

        // Polymorphic çağrı - tüm abonelerin toplam AI Credit bilgisini tek bir döngüde
        // hesaplayabiliriz!
        System.out.println("4. Polymorphic Hesaplama (tüm abone türleri)");
        displayTotalCredits(subscribers);
    }

    private static void displayTotalCredits(List<Subscriber> subscribers) {
        double totalCredits = 0;
        for (Subscriber sub : subscribers) {
            double credit = sub.calculateAiCredit();
            System.out.printf("  %s (%s): %.4f AI Credits\n",
                    sub.getFullName(),
                    sub.getClass().getSimpleName(),
                    credit);
            totalCredits += credit;
        }
        System.out.printf("Toplam: %.4f AI Credits\n", totalCredits);
    }
}