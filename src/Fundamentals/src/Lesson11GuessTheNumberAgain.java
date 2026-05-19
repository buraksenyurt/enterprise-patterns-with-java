import java.util.Random;
import java.util.Scanner;

public class Lesson11GuessTheNumberAgain {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int userGuess;
        int attempts = 0;
        int min = 1;
        int max = 100;
        int computerNumber = rand.nextInt(min, max + 1);

        System.out.printf("Zihnimi oku ve hangi sayıyı tuttuğumu tahmin et.\n%d ile %d arasından bir sayı tuttum.", min, max);

        do {
            System.out.println("Taminin? ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < computerNumber) {
                System.out.println("Tahminimden küçük bir sayı söyledin. Tekrar dene");
            } else if (userGuess > computerNumber) {
                System.out.println("Tahminimden büyük bir sayı söyledin. Tekrar dene");
            } else {
                System.out.printf("# %d seferde doğru sayıyı buldun", attempts);
            }
        } while (userGuess != computerNumber);

        System.out.println("Yeniden görüşmek üzere.");
        
        scanner.close();
    }
}
