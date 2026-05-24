import java.util.ArrayList;
import java.util.Collections;

public class Lesson25ArrayList {
    public static void run() {
        ArrayList<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit(1, "Orange"));
        fruits.add(new Fruit(2, "Apple"));
        fruits.add(new Fruit(3, "Pear"));
        fruits.add(new Fruit(4, "Strawberry"));
        fruits.add(new Fruit(5, "Mango"));
        fruits.add(new Fruit(6, "Grape"));
        fruits.add(new Fruit(7, "Banana"));
        fruits.set(1, new Fruit(2, "PineApple"));
        fruits.add(new Fruit(0, "Apple"));
        fruits.remove(4);

        System.out.println("Fruits size: " + fruits.size());
        System.out.println(fruits);
        printFruits(fruits);

        Collections.sort(fruits);
        System.out.println("\nSorted Fruits: ");
        printFruits(fruits);
    }

    static void printFruits(ArrayList<Fruit> fruits) {
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }
}

class Fruit implements Comparable<Fruit> {
    private int id;
    private String name;

    Fruit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    // Collections.sort metodunun çalışması için compare işlemini öğretmek gerekir
    @Override
    public int compareTo(Fruit o) {
        return this.name.compareTo(o.name);
    }
}
