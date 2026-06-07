package SOLID.Liskov.LiskovIdeal;

public interface ApproximateTokenCalculator extends TokenCalculator {
    double getApproximationError();
    
    @Override
    double calculateCost(long tokens);
}
