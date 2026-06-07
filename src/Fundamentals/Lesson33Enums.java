import java.util.Scanner;

public class Lesson33Enums {
    public static void run() {

        ThemeColor color = ThemeColor.RED;
        System.out.println("Selected color: " + color);
        System.out.println("RGB values: " + color.getRgb());

        System.out.println("\nAll available colors:");

        for (ThemeColor c : ThemeColor.values()) {
            System.out.println(c + " RGB: " + c.getRgb());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter your favorite color: ");
        String response = scanner.nextLine().toUpperCase();
        try {
            ThemeColor userColor = ThemeColor.valueOf(response);
            switch (userColor) {
                case RED, GREEN, BLUE -> System.out.println("Primary colors");
                case YELLOW, ORANGE, PURPLE -> System.out.println("Secondary colors");
                case BLACK, WHITE -> System.out.println("Monochrome colors");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid color: " + response);
        }

        scanner.close();

    }
}
