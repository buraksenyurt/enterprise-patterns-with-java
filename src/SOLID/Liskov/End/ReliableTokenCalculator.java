package SOLID.Liskov.End;

public interface ReliableTokenCalculator extends TokenCalculator {
    @Override
    double calculateCost(long tokens);
}
