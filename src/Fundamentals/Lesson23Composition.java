import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lesson23Composition {
    public static void run() {
        /*
        nesneler arasında `part-of` ilişkisini temsil eder.
        Karmaşık(complex) nesnelerin daha küçük nesnelerle ifade edilmesinde değerlendirilir.

        Bu senaryoda aggregation'daki bağımsız yaşam döngüsünün aksine bağımlı yaşam döngüsü vardır.
        Konteyner görevi gören nesne yok edildiğinde içerdiği nesneler de anlamsızlaşır ve yok edilir.

        Order ve OrderItem buna güzel bir örnek. Bir sipariş, sipariş kalemleri ile birlikte anlamlıdır.
        */

        Order myOrder = new Order("OBK-2026-000001");
        myOrder.addItem("Programming with Rust", "Book", 34.50, 1);
        myOrder.addItem("Blueprint Pencil 0.5", "OEM", 5.50, 3);
        myOrder.addItem("Java Cheatsheet poster 1080P", "OEM", 12.49, 2);

        myOrder.printOrder();

        // myOrder nesnesi yok edildiğinde içindeki OrderItem nesneleri de Garbage Collector tarafından
        // toplanır ve temizlenir. OrderItem'ların bağımsız olarak ele alınması anlamsızdır.
        // Hatta OrderItem'ın sadece Order tarafından kullanılması için paket seviyesinde private
        // veya inner class şeklinde de tasarlanabilir.
    }
}

class Order {
    private String orderId;
    private LocalDate orderDate;
    private List<OrderItem> items;

    public Order(String orderId) {
        this.orderId = orderId;
        this.orderDate = LocalDate.now();
        this.items = new ArrayList<>();
    }

    public void addItem(String productName, String category, double unitPrice, int quantity) {
        OrderItem item = new OrderItem(productName, category, quantity, unitPrice);
        this.items.add(item);
    }

    public void printOrder() {
        System.out.println("Order ID: " + this.orderId + " Order Date: " + this.orderDate);
        double total = 0;
        for (OrderItem item : this.items) {
            System.out.println("-\t" + item.toString());
            total += item.getTotal();
        }
        System.out.println("Total Price: " + total);
    }
}

class OrderItem {
    private String productName;
    private String category;
    private int quantity;
    private double unitPrice;

    OrderItem(String productName, String category, int quantity, double unitPrice) {
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return unitPrice * quantity;
    }

    @Override
    public String toString() {
        return productName + " (" + category + ") " + quantity + " unit. Total price " + getTotal();
    }
}
