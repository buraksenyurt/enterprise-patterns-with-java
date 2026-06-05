import java.util.Random;
import java.util.Scanner;

public class Lesson04GuessTheNumber {
    public static void run() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(1, 6);

        System.out.println("Aklımdan bir sayı tuttum. 1 ile 6 arasında. Tek hakkın var.");
        int guess = input.nextInt();

        if (guess == number) {
            System.out.println("Bravo! Tek seferde bildin.");
        } else {
            System.out.println("Üzgünüm :(\nAklımdaki sayı = " + number);
        }

        input.close();
    }
}
