import java.time.LocalDate;
import java.util.UUID;

public class Lesson21GetterSetter {
    public static void run() {
        var purchase = new Purchase(19, "TL");
        printPurchase(purchase);
        purchase.setPrice(purchase.getPrice() + 1.80);
        purchase.setCurrency("USD");
        var acceptDate = LocalDate.now().plusDays(1);
        purchase.setAcceptedDate(acceptDate);
        purchase.setPrice(-10);
        printPurchase(purchase);
    }

    static void printPurchase(Purchase purchase) {
        System.out.println(purchase.getId() + "," + purchase.getAcceptedDate() + "," + purchase.getPrice() + " " + purchase.getCurrency());

    }
}

class Purchase {
    private final UUID id;
    private LocalDate acceptedDate;
    private double price;
    private String currency;

    Purchase(double price, String currency) {
        this.id = UUID.randomUUID();
        setAcceptedDate(LocalDate.now());
        setPrice(price);
        setCurrency(currency);
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(LocalDate acceptedDate) {
        if (acceptedDate == null || acceptedDate.isAfter(LocalDate.now())) {
            System.err.println("Invalid accepted date. Setting to today.");
            this.acceptedDate = LocalDate.now();
            return;
        }
        this.acceptedDate = acceptedDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            System.err.println("Invalid price. Setting to 1");
            this.price = 1;
            return;
        }
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
