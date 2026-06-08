package SOLID.OpenClosed.End;

import java.util.List;

import SOLID.OpenClosed.Common.SessionHistory;

// Grok: Bütçe dostu LLM provider'ı, indirim desteğiyle.
// OCP'nin "Açık extension'a" kısmını karşılar.
public class GrokSubscriber extends Subscriber {
    private String subscriptionTier; // "starter" veya "plus"
    private int discountPercent;     // 0-100 arası indirim %

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setSubscriptionTier(String subscriptionTier) {
        this.subscriptionTier = subscriptionTier;
    }

    public String getSubscriptionTier() {
        return subscriptionTier;
    }

    @Override
    public double calculateAiCredit() {
        List<SessionHistory.Context> sessions = SessionHistory.getCurrentContexts(subscriberId);
        long totalTokens = sessions.stream()
                .mapToLong(SessionHistory.Context::getContextTokens)
                .sum();

        double baseRate = 0.0008;  // Ekonomik fiyat
        double tierMultiplier = "plus".equalsIgnoreCase(subscriptionTier) ? 1.1 : 1.0;
        double discountFactor = 1.0 - (discountPercent / 100.0);

        return totalTokens * baseRate * tierMultiplier * discountFactor;
    }
}
