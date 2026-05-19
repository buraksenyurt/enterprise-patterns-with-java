void main(String[] args) {
    if (args.length > 0) {
        runByCode(args[0]);
        return;
    }

    Scanner scanner = new Scanner(System.in);
    IO.println("Fundamentals Lesson Launcher");
    IO.println("0: L00 Hello World");
    IO.println("1: L01 Mad Libs Game");
    IO.println("2: L02 Operators");
    IO.println("3: L03 Conditions");
    IO.println("4: L04 Guess The Number");
    IO.println("5: L05 Some Math Functions");
    IO.println("6: L06 Printf Sample");
    IO.println("7: L07 String Members");
    IO.print("Select lesson (0-7): ");

    int selection = scanner.nextInt();
    runByCode(String.valueOf(selection));
}

private static void runByCode(String code) {
    switch (code) {
        case "0":
        case "L00":
            Lesson00HelloWorld.run();
            break;
        case "1":
        case "L01":
            Lesson01MadLibsGame.run();
            break;
        case "2":
        case "L02":
            Lesson02Operators.run();
            break;
        case "3":
        case "L03":
            Lesson03Conditions.run();
            break;
        case "4":
        case "L04":
            Lesson04GuessTheNumber.run();
            break;
        case "5":
        case "L05":
            Lesson05SomeMath.run();
            break;
        case "6":
        case "L06":
            Lesson06Printf.run();
            break;
        case "7":
        case "L07":
            Lesson07StringMembers.run();
            break;
        default:
            IO.println("Unknown lesson code: " + code);
            IO.println("Use 0-7 or L00-L07");
            break;
    }
}
