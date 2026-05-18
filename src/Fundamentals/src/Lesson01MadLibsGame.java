import java.util.Scanner;

public class Lesson01MadLibsGame {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        String adjective1;
        String noun1;
        String adjective2;
        String verb1;
        String adjective3;

        adjective1 = getAdjective(scanner);
        IO.print("Enter a noun (animal, person, or something suspicious): ");
        noun1 = scanner.nextLine();
        adjective2 = getAdjective(scanner);
        IO.print("Enter a verb ending with -ing (action): ");
        verb1 = scanner.nextLine();
        adjective3 = getAdjective(scanner);

        IO.println("\nToday I accidentally walked into a " + adjective1.toUpperCase() + " supermarket.");
        IO.println("Right next to the bananas, I saw a " + noun1.toUpperCase() + " wearing sunglasses.");
        IO.println("The " + noun1 + " looked very " + adjective2.toUpperCase() + " and started " + verb1.toUpperCase() + " near the cash register.");
        IO.println("Nobody panicked because apparently this happens every Tuesday.");
        IO.println("I stood there, completely " + adjective3.toUpperCase() + ", while a cashier offered it a discount card.");
    }

    private static String getAdjective(Scanner scanner) {
        IO.print("Enter an adjective (description): ");
        return scanner.nextLine();
    }
}
