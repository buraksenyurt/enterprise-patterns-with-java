package SOLID.OpenClosedBegin;

import java.util.List;

import SOLID.OpenClosedCommon.SessionHistory;

public class ClaudeSubscriber {
    private Long subscriberId;
    private String subscriptionTier; // "pro", "standard"
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

    public double calculateAiCredit() {
        List<SessionHistory.Context> sessions = SessionHistory.getCurrentContexts(subscriberId);
        long totalTokens = sessions.stream().mapToLong(SessionHistory.Context::getContextTokens).sum();
        
        double baseRate = 0.003;
        double tierMultiplier = "pro".equalsIgnoreCase(subscriptionTier) ? 1.2 : 1.0;
        
        return totalTokens * baseRate * tierMultiplier;
    }
}
