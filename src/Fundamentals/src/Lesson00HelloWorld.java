import java.util.Scanner;

public class Lesson00HelloWorld {
    public static void run() {
        System.out.println("This is a Java World");
        Scanner reader = new Scanner(System.in);

        System.out.print("What is your name?");
        String name = reader.nextLine();

        System.out.print("What is your age?");
        int age = reader.nextInt();

        System.out.println("Hello " + name + ". Your age is " + age);

        double temperature = 22.5;
        System.out.println("Today the weather is " + temperature);

        System.out.print("Do you want to enter the game? (Yes/No)");
        char choice = reader.next().charAt(0);
        if (choice == 'Y') {
            System.out.println("Welcome to the game!");
        } else {
            System.out.println("May be the next time");
        }

        System.out.println("Are you a student? (true/false)");
        boolean answer = reader.nextBoolean();
        if (answer) {
            System.out.println("You have a bonus coin to play on game!");
        } else {
            System.out.println("Sorry, you are not a student!");
        }

        System.out.println("What is your graduate point ");
        double point = reader.nextDouble();
        reader.nextLine();

        System.out.println("What is your favorite color?");
        String color = reader.nextLine();
        System.out.println("Your favorite color is " + color);

        double width;
        double height;

        System.out.println("Enter the width: ");
        width = reader.nextDouble();
        System.out.println("Enter the height: ");
        height = reader.nextDouble();

        double area = width * height;
        System.out.println("The area is " + area + "cm²");

        if (point < 0) {
            System.out.println("Invalid point value");
        }

        reader.close();
    }
}
