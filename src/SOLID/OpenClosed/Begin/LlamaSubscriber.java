package SOLID.OpenClosed.Begin;

import java.util.List;

import SOLID.OpenClosed.Common.SessionHistory;

public class LlamaSubscriber {
    private Long subscriberId;
    private boolean batchProcessingEnabled;
    private String fullName;

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

    public void setBatchProcessingEnabled(boolean batchProcessingEnabled) {
        this.batchProcessingEnabled = batchProcessingEnabled;
    }

    public boolean isBatchProcessingEnabled() {
        return batchProcessingEnabled;
    }

    public double calculateAiCredit() {
        List<SessionHistory.Context> sessions = SessionHistory.getCurrentContexts(subscriberId);
        long totalTokens = sessions.stream().mapToLong(SessionHistory.Context::getContextTokens).sum();
        
        double baseRate = 0.0001;
        double baseCredit = totalTokens * baseRate;
        
        double batchBonus = batchProcessingEnabled ? baseCredit * 0.05 : 0;
        
        return baseCredit + batchBonus;
    }
}
