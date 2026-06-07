package SOLID.Liskov.LiskovIdeal;

public class OfflineTokenCalculator implements ReliableTokenCalculator {
    
    private boolean isConnected = false;
    
    public OfflineTokenCalculator() {
        this.isConnected = false;
    }
    
    @Override
    public double calculateCost(long tokens) {
        if (!isConnected) {
            return 0;
        }
        
        double RATE_PER_TOKEN = 0.002;
        return tokens * RATE_PER_TOKEN;
    }
    
    public boolean isConnected() {
        return isConnected;
    }
    
    public void connect() {
        this.isConnected = true;
    }
    
    public void disconnect() {
        this.isConnected = false;
    }
}
