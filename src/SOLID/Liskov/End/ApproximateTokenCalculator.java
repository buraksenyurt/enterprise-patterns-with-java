package SOLID.Liskov.End;

public interface ApproximateTokenCalculator extends TokenCalculator {
    double getApproximationError();
    
    @Override
    double calculateCost(long tokens);
}
