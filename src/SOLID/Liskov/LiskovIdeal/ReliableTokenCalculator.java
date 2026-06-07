package SOLID.Liskov.LiskovIdeal;

public interface ReliableTokenCalculator extends TokenCalculator {
    @Override
    double calculateCost(long tokens);
}
