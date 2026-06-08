package SOLID.OpenClosed.Common;

import java.time.LocalDateTime;

public class Utility {
    public static void setupTestContexts() {
        long[][] testData = {
                { 1001L, 5000L }, // Claude session 1: 5k tokens
                { 1001L, 8000L }, // Claude session 2: 8k tokens
                { 1001L, 3000L }, // Claude session 3: 3k tokens (toplam: 16k)
                { 1002L, 10000L }, // Grok session 1: 10k tokens
                { 1002L, 7000L }, // Grok session 2: 7k tokens
                { 1002L, 6000L }, // Grok session 3: 6k tokens (toplam: 23k)
                { 1003L, 20000L }, // Llama session 1: 20k tokens
                { 1003L, 15000L }, // Llama session 2: 15k tokens
                { 1003L, 12000L } // Llama session 3: 12k tokens (toplam: 47k)
        };

        for (long[] data : testData) {
            SessionHistory.addContext(
                    data[0],
                    LocalDateTime.now(),
                    data[1]);
        }
    }

    public static void displayCredit(String model, double credit) {
        System.out.printf("  %s: %.4f AI Credits\n", model, credit);
    }
}
