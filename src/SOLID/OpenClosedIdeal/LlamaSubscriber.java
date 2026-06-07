package SOLID.OpenClosedIdeal;

import java.util.List;

import SOLID.OpenClosedCommon.SessionHistory;

// Llama: Açık kaynak LLM provider'ı, toplu işlem bonusuyla.
// OCP'nin "Open to extension" ifadesini karşılar.
public class LlamaSubscriber extends Subscriber {
    private boolean batchProcessingEnabled; // Toplu işlem bonusu aktif?

    public void setBatchProcessingEnabled(boolean batchProcessingEnabled) {
        this.batchProcessingEnabled = batchProcessingEnabled;
    }

    public boolean isBatchProcessingEnabled() {
        return batchProcessingEnabled;
    }

    @Override
    public double calculateAiCredit() {
        List<SessionHistory.Context> sessions = SessionHistory.getCurrentContexts(subscriberId);
        long totalTokens = sessions.stream()
                .mapToLong(SessionHistory.Context::getContextTokens)
                .sum();

        double baseRate = 0.0001; // Topluluk fiyatı
        double baseCredit = totalTokens * baseRate;
        double batchBonus = batchProcessingEnabled ? baseCredit * 0.05 : 0; // %5 toplu işlem bonusu

        return baseCredit + batchBonus;
    }
}
