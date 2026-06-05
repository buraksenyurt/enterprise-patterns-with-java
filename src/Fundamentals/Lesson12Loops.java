import java.util.Scanner;

public class Lesson12Loops {
    public static void run() throws InterruptedException {
        // Some Loops

        double sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1den 100'e kadar olan sayıların toplamı (100 dahil) " + sum);

        System.out.println("Şimdide 10dan geriye doğru sayalım");
        for (int i = 10; i >= 0; i--) {
            System.out.print(i + ",");
            Thread.sleep(500);
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        // Nested Loop
        int rows;
        int cols;
        char symbol;
        System.out.println("Satır sayısını gir: ");
        rows = scanner.nextInt();
        System.out.println("Sütun sayısı: ");
        cols = scanner.nextInt();
        System.out.println("Sembol? ");
        symbol = scanner.next().charAt(0);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }

        System.out.println("Bu da sonsuz for döngüsü olsun...Çıkmak için quit yaz.");
        // for(;;) döngüsü de denenebilir
        String input;
        do {
            System.out.println("-> ");
            input = scanner.next();
        } while (!input.equals("quit"));

        scanner.close();
    }
}
