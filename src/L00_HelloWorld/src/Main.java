void main() {
    IO.println("This is a Java World");
    Scanner reader = new Scanner(System.in);

    IO.print("What is your name?");
    String name = reader.nextLine();

    IO.print("What is your age?");
    int age = reader.nextInt();

    IO.println("Hello " + name+ ". Your age is " + age);

    double temperature = 22.5;

    System.out.println("Today the weather is " + temperature);
    IO.print("Do you want to enter the game? (Yes/No)");
    char choice = reader.next().charAt(0);
    if(choice == 'Y'){
        IO.println("Welcome to the game!");
    } else {
        IO.println("May be the next time");
    }

    IO.println("Are you a student? (true/false)");
    boolean answer = reader.nextBoolean();
    if(answer){
        IO.println("You have a bonus coin to play on game!");
    } else {
        IO.println("Sorry, you are not a student!");
    }

    // Buffer Issue
    IO.println("What is your graduate point ");
    double point = reader.nextDouble();
    reader.nextLine(); // Comment out this line to see buffer issue. Use this to clear the input buffer.

    IO.println("What is your favorite color?");
    String color = reader.nextLine();
    IO.println("Your favorite color is " + color);
    // Buffer Issue

    double width;
    double height;

    IO.println("Enter the width: ");
    width = reader.nextDouble();
    IO.println("Enter the height: ");
    height = reader.nextDouble();

    double area = width*height;
    IO.println("The area is " + area + "cm²"); // for ² Numlock + Alt + 0178 (for windows)

    reader.close();
}
