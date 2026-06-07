package SOLID.Liskov.LiskovIdeal;

public class FastTokenCalculator implements ApproximateTokenCalculator {
    private static final double RATE_PER_TOKEN = 0.002;
    private static final double APPROXIMATION_ERROR = 0.15; // + veya - %15 hata
    
    @Override
    public double calculateCost(long tokens) {
        if (tokens < 0) {
            return 0;
        }
        
        long seed = tokens * 12345L;
        double randomFactor = 1.0 + (((seed % 100) / 100.0 - 0.5) * 2 * APPROXIMATION_ERROR);
        
        double baseCost = tokens * RATE_PER_TOKEN;
        return baseCost * randomFactor;
    }
    
    @Override
    public double getApproximationError() {
        return APPROXIMATION_ERROR;
    }
}
