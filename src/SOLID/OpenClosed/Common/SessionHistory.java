package SOLID.OpenClosed.Common;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
SessionHistory: Tüm LLM modelleri tarafından paylaşılan ortak utility sınıfı.
Abone oturumlarını ve context token'larını depolar.
*/
public class SessionHistory {

    // Bir abonelik oturumunu temsil eder.
    // Her oturum: başlama zamanı, token sayısı, ve abone ID'si içerir.
    public static class Context {

        private LocalDateTime begin;
        private long contextTokens;  // Oturumda kullanılan token sayısı
        private Long subscriberId;

        public Context(Long subscriberId, LocalDateTime begin, long contextTokens) {
            this.begin = begin;
            this.contextTokens = contextTokens;
            this.subscriberId = subscriberId;
        }

        public LocalDateTime getBegin() {
            return begin;
        }

        public long getContextTokens() {
            return contextTokens;
        }

        public Long getSubscriberId() {
            return subscriberId;
        }
    }

    private static final Map<Long, List<Context>> CONTEXTS = new HashMap<>();

    // synchronized: Çoklu thread'lerin aynı anda oturum eklemesini veya okumasını engeller
    public synchronized static List<Context> getCurrentContexts(Long subscriberId) {
        if (!CONTEXTS.containsKey(subscriberId)) {
            return Collections.emptyList();
        }
        return CONTEXTS.get(subscriberId);
    }

    public synchronized static void addContext(Long subscriberId, LocalDateTime begin, long contextTokens) {
        List<Context> contexts;
        if (!CONTEXTS.containsKey(subscriberId)) {
            contexts = new LinkedList<>();
            CONTEXTS.put(subscriberId, contexts);
        } else {
            contexts = CONTEXTS.get(subscriberId);
        }
        contexts.add(new Context(subscriberId, begin, contextTokens));
    }
}
