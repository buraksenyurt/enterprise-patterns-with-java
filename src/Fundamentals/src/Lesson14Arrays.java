import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson14Arrays {
    public static void run() {
        // Arrays

        String[] colors = {"Red", "Green", "Blue", "Yellow", "White", "Black", "Gray"};
        Arrays.sort(colors);
        // Enhanced for
        for (String color : colors) {
            System.out.println(color);
        }

        // varargs
        fruitCollector("apple", "banana", "orange");
        fruitCollector("cherry");
        fruitCollector("pear", "pineapple", "mango", "chocolate", "strawberry", "garlic");

        // 2D Array
        int[][] gameScene = {
                {1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
        };
        for (int[] rows : gameScene) {
            for (int col : rows) {
                if (col == 1) {
                    System.out.print("T ");
                } else {
                    System.out.print("W ");
                }
            }
            System.out.println();
        }

        // Search
        int[] points = {5, 2, 6, 7, 0, 1, 13, 19, 8, 6, 24};
        for (int point : points) {
            if (point % 3 == 0) System.out.println(point);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bana güzel birşeyler söyle");
        String input = scanner.nextLine();
        printFunny(input);
        scanner.close();
    }

    static void printFunny(String input) {
        Random rand = new Random();
        String symbol;
        for (int i = 0; i < input.length(); i++) {
            if (rand.nextBoolean()) {
                symbol = "☕";
            } else {
                symbol = "⭐";
            }
            System.out.print(input.charAt(i) + symbol);
        }
        System.out.println();
    }

    //varargs sample
    static void fruitCollector(String... fruits) {
        for (String fruit : fruits) {
            System.out.print(fruit + ",");
        }
        System.out.println();
    }
}
