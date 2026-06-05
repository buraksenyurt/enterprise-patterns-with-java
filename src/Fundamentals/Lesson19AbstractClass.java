import java.util.Date;
import java.util.UUID;

public class Lesson19AbstractClass {
    public static void run() {
        // Entity entity = new Entity(); // It is impossible because of Entity is abstract class
        Entity[] entities = {
                new Customer("John Jey Smith", "ACN11101"),
                new Invoice(1000)
        };
        for (Entity entity : entities) {
            entity.onAfterCreate();
        }
    }
}

abstract class Entity {
    UUID id;

    abstract void onAfterCreate();
}

class Invoice extends Entity {
    double totalAmount;
    Date acceptedDate;

    Invoice(double amount) {
        super.id = UUID.randomUUID();
        this.totalAmount = amount;
        this.acceptedDate = new Date();
    }

    @Override
    void onAfterCreate() {
        System.out.println("Invoice onAfterSave called");
    }
}

class Customer extends Entity {
    String fullName;
    String accountNumber;

    Customer(String fullName, String accountNumber) {
        super.id = UUID.randomUUID();
        this.fullName = fullName;
        this.accountNumber = accountNumber;
    }

    @Override
    void onAfterCreate() {
        System.out.println("Customer onAfterSave called");
    }
}


