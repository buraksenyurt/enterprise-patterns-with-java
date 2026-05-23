public class Lesson16Objects {
    public static void run() {
        Product product = new Product();

        System.out.println(product);

        product.id = 1001;
        product.name = "Optical Mouse";
        product.price = 12.5;
        product.onStock = true;
        System.out.println(product.getInfo());

        product.discount(1.5);
        System.out.println(product.getInfo());

        Product product2 = new Product(1002, "ElCi 40inch 1080 Monitor", 2120);
        System.out.println(product2.getInfo());

        Chrono time = new Chrono(8, 24);
        System.out.println(time);

        time = new Chrono(9, 26, 34);
        System.out.println(time);
    }
}

class Product {
    // Attributes
    int id;
    String name;
    double price;
    boolean onStock;

    // Constructor

    // Default Constructor
    Product() {

    }

    // Parameterized Constructor

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.onStock = true;
    }

    Product(int id, String name, double price, boolean onStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.onStock = onStock;
    }

    // Instance methods
    void discount(double amount) {
        if (amount <= 0 || amount >= price) {
            System.out.println("Invalid amount");
            return;
        }
        price -= amount;
    }

    String getInfo() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price;
    }
}