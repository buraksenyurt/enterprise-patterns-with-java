package SOLID.OpenClosedIdeal;

/**
 * OCP Prensibi: Open/Closed Principle (Açık/Kapalı Prensibi)
 * 
 * Bu abstract sınıf OCP'nin "Closed to modification" ifadesini karşılar.
 * Yeni LLM eklemek için bu sınıfı değiştirmemize gerek yoktur, sadece extend
 * ederiz.
 * 
 * OCP: "Yazılım varlıkları (sınıflar, fonksiyonlar) genişletilmeye açık,
 * değişime kapalı olmalıdır." der. Orjinali; Open for extension, closed for modification."
 */
public abstract class Subscriber {
    protected Long subscriberId;
    protected String fullName;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    /**
     * Her LLM provider'ı kendi AI Credit hesaplama mantığını implement eder.
     * Bu "Open for extension" demek: yeni LLM = yeni class + override.
     * Bu metodu değiştirmemize gerek yok.
     */
    public abstract double calculateAiCredit();
}
