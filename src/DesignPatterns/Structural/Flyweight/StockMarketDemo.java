package DesignPatterns.Structural.Flyweight;

import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StockMarketDemo {
    public static void main(String[] args) {
        DataLoaderService dataLoaderService = new DataLoaderService();
        FinancialInstrumentFactory instrumentFactory = new FinancialInstrumentFactory(dataLoaderService);

        String[] symbols = { "OPNA", "ANTR", "ORCL", "AMZN", "TSLA" };
        List<Order> orders = new ArrayList<>();
        Random random = new Random(24);

        for (int i = 0; i < 1000; i++) {
            String symbol = symbols[random.nextInt(symbols.length)];
            OrderType orderType = random.nextBoolean() ? OrderType.BUY : OrderType.SELL;
            int quantity = random.nextInt(100) + 1;
            java.math.BigDecimal price = new java.math.BigDecimal(random.nextDouble() * 1000).setScale(2,
                    RoundingMode.HALF_UP);
            orders.add(
                    new Order(i, orderType, instrumentFactory.getInstrument(symbol), quantity, price, Instant.now()));
        }

        System.out.println("Total orders: " + orders.size());
        System.out.println("Total instrument lookups: " + dataLoaderService.getLookupCount());
    }
}
