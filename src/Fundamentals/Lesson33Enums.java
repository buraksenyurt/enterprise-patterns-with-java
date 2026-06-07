import java.util.Scanner;

public class Lesson33Enums {
    public static void run() {

        ThemeColor color = ThemeColor.RED;
        System.out.println("Seçilen renk: " + color);
        System.out.println("RGB değerleri: " + color.getRgb());

        System.out.println("\nTüm mevcut renkler:");

        for (ThemeColor c : ThemeColor.values()) {
            System.out.println(c + " RGB: " + c.getRgb());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nFavori renginizi girin: ");
        String response = scanner.nextLine().toUpperCase();
        try {
            ThemeColor userColor = ThemeColor.valueOf(response);
            switch (userColor) {
                case RED, GREEN, BLUE -> System.out.println("Birincil renkler");
                case YELLOW, ORANGE, PURPLE -> System.out.println("İkincil renkler");
                case BLACK, WHITE -> System.out.println("Monokrom renkler");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Geçersiz renk: " + response);
        }

        scanner.close();

    }
}
