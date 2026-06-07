package SOLID.OpenClosedBegin;

import java.util.List;

public class GrokSubscriber {
    private Long subscriberId;
    private String subscriptionTier; // "starter", "plus"
    private int discountPercent;
    private String fullName;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setSubscriptionTier(String subscriptionTier) {
        this.subscriptionTier = subscriptionTier;
    }

    public String getSubscriptionTier() {
        return subscriptionTier;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public double calculateAiCredit() {
        List<SessionHistory.Context> sessions = SessionHistory.getCurrentContexts(subscriberId);
        long totalTokens = sessions.stream().mapToLong(SessionHistory.Context::getContextTokens).sum();
        
        double baseRate = 0.0008;
        double tierMultiplier = "plus".equalsIgnoreCase(subscriptionTier) ? 1.1 : 1.0;
        double discountFactor = 1.0 - (discountPercent / 100.0);
        
        return totalTokens * baseRate * tierMultiplier * discountFactor;
    }
}
