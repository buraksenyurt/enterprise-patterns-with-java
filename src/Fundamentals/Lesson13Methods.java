import java.util.Scanner;

public class Lesson13Methods {
    public static void run() {
        // Method Usages (basic)
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConcatTwoWords("Hello", "world", '|'));

        Greetings();

        System.out.println("Gauss toplamı. Üst sınırı girin");
        int maxValue = scanner.nextInt();
        int result = GaussSum(maxValue);
        System.out.printf("0'dan %d'ye kadar sayıların toplamı %d\n", maxValue, result);

        System.out.println("Şimdi bir alt sınır girin.");
        int minValue = scanner.nextInt();
        System.out.println("Tekrar üst sınırı girin.");
        maxValue = scanner.nextInt();
        result = GaussSum(minValue, maxValue);
        System.out.printf("%d - %d aralığındaki tam sayıların toplamı %d\n", minValue, maxValue, result);

        // int total = Total(1, 2, 3, 4);
        int total = Total(5, 2, 7, 1, -1, 6);
        System.out.println(total);
        scanner.close();
    }

    public static void Greetings() {
        System.out.println("Bu uygulamada örnek metot kullanımları yer almaktadır");

    }

    public static int GaussSum(int max) {
        return GaussSum(0, max);
    }

    // Overloading
    public static int GaussSum(int min, int max) {
        if (min < 0 || min > max) {
            System.out.println("Minimum değer negatif veya üst limitten büyük olamaz.");
        }
        int result = 0;
        for (int i = min; i <= max; i++) {
            result += i;
        }
        return result;
    }

    public static String ConcatTwoWords(String first, String second, char symbol) {
        return first + symbol + second;
    }

    // varargs (C# taki params)
    public static int Total(int... numbers) {
        int result = 0;
        for (int i : numbers) {
            result += i;
        }
        return result;
    }
}
