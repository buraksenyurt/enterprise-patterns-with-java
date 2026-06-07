package SOLID.OpenClosedIdeal;

import java.util.List;

import SOLID.OpenClosedCommon.SessionHistory;

/**
 * Claude: Premium LLM provider'ı.
 * OCP'nin "Açık extension'a" kısmını karşılar - Subscriber'ı extend ederek kendi mantığını implement eder.
 */
public class ClaudeSubscriber extends Subscriber {
    private String subscriptionTier; // "pro" veya "standard"

    public void setSubscriptionTier(String subscriptionTier) {
        this.subscriptionTier = subscriptionTier;
    }

    public String getSubscriptionTier() {
        return subscriptionTier;
    }

    /**
     * Claude'a özel AI Credit hesaplama:
     * Formül: tokens × baseRate × tierMultiplier
     * baseRate = 0.003 (premium)
     * pro tier = 1.2x, standard tier = 1.0x
     */
    @Override
    public double calculateAiCredit() {
        List<SessionHistory.Context> sessions = SessionHistory.getCurrentContexts(subscriberId);
        long totalTokens = sessions.stream()
                .mapToLong(SessionHistory.Context::getContextTokens)
                .sum();

        double baseRate = 0.003; // Premium fiyat
        double tierMultiplier = "pro".equalsIgnoreCase(subscriptionTier) ? 1.2 : 1.0;

        return totalTokens * baseRate * tierMultiplier;
    }
}
