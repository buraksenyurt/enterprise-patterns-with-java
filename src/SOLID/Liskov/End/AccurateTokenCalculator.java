package SOLID.Liskov.End;

public class AccurateTokenCalculator implements ReliableTokenCalculator {
    private static final double RATE_PER_TOKEN = 0.002;

    @Override
    public double calculateCost(long tokens) {
        if (tokens < 0) {
            return 0;
        }
        return tokens * RATE_PER_TOKEN;
    }
}
