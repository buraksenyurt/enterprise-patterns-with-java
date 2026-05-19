import java.util.Scanner;

public class Lesson08LengthConverter {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        double measurement;
        double converted;
        int choice;
        double inchConst = 2.54;

        System.out.println("Cm / Inch Converter");
        System.out.println("1: Convert cm to inches");
        System.out.println("2: Convert inches to cm");

        choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Input as Cm: ");
            measurement = scanner.nextDouble();
            converted = measurement / inchConst;
            System.out.printf("%.2f cm is %.2f inches\n", measurement, converted);
        } else if (choice == 2) {
            System.out.println("Input as Inches: ");
            measurement = scanner.nextDouble();
            converted = measurement * inchConst;
            System.out.printf("%.2f inches is %.2f cm\n", measurement, converted);
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.nextLine();
    }
}
