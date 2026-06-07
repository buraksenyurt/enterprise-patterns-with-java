import java.util.Scanner;

public class Fundamentals {

    public static void main(String[] args) throws InterruptedException {
        if (args.length > 0) {
            runByCode(args[0]);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Fundamentals Lesson Launcher");
        System.out.println("0 : L00 Hello World");
        System.out.println("1 : L01 Mad Libs Game");
        System.out.println("2 : L02 Operators");
        System.out.println("3 : L03 Conditions");
        System.out.println("4 : L04 Guess The Number");
        System.out.println("5 : L05 Some Math Functions");
        System.out.println("6 : L06 Printf Sample");
        System.out.println("7 : L07 String Members");
        System.out.println("8 : L08 Inch/Cm Calculator");
        System.out.println("9 : L09 Enhanced Switch");
        System.out.println("10: L10 Password Checker");
        System.out.println("11: L11 Guess the number again");
        System.out.println("12: L12 Loops");
        System.out.println("13: L13 Methods");
        System.out.println("14: L14 Arrays");
        System.out.println("15: L15 2D Scene Creator");
        System.out.println("16: L16 Objects");
        System.out.println("17: L17 Static");
        System.out.println("18: L18 Inheritance");
        System.out.println("19: L19 Abstract classes");
        System.out.println("20: L20 Interfaces");
        System.out.println("21: L21 Getters and Setters");
        System.out.println("22: L22 Aggregation");
        System.out.println("23: L23 Composition");
        System.out.println("24: L24 Wrapper");
        System.out.println("25: L25 ArrayList");
        System.out.println("26: L26 Exceptions");
        System.out.println("27: L27 File Write/Read Operations");
        System.out.println("28: L28 Date and Time");
        System.out.println("29: L29 Anonymous Classes");
        System.out.println("30: L30 Scheduling with TimerTask");
        System.out.println("31: L31 Generics");
        System.out.println("32: L32 Hashmap");
        System.out.println("33: L33 Enums");
        System.out.println("34: L34 Threading");
        System.out.println("35: L35 Multi-threading with Runnable");
        System.out.println("36: L36 ExecutorService");
        System.out.print("Select lesson ");

        int selection = scanner.nextInt();
        runByCode(String.valueOf(selection));
        scanner.close();
    }

    private static void runByCode(String code) throws InterruptedException {
        switch (code) {
            case "0", "L00" -> Lesson00HelloWorld.run();
            case "1", "L01" -> Lesson01MadLibsGame.run();
            case "2", "L02" -> Lesson02Operators.run();
            case "3", "L03" -> Lesson03Conditions.run();
            case "4", "L04" -> Lesson04GuessTheNumber.run();
            case "5", "L05" -> Lesson05SomeMath.run();
            case "6", "L06" -> Lesson06Printf.run();
            case "7", "L07" -> Lesson07StringMembers.run();
            case "8", "L08" -> Lesson08LengthConverter.run();
            case "9", "L09" -> Lesson09EnhancedSwitch.run();
            case "10", "L10" -> Lesson10PasswordChecker.run();
            case "11", "L11" -> Lesson11GuessTheNumberAgain.run();
            case "12", "L12" -> Lesson12Loops.run();
            case "13", "L13" -> Lesson13Methods.run();
            case "14", "L14" -> Lesson14Arrays.run();
            case "15", "L15" -> Lesson15SceneCreator.run();
            case "16", "L16" -> Lesson16Objects.run();
            case "17", "L17" -> Lesson17Static.run();
            case "18", "L18" -> Lesson18Inheritance.run();
            case "19", "L19" -> Lesson19AbstractClass.run();
            case "20", "L20" -> Lesson20Interface.run();
            case "21", "L21" -> Lesson21GetterSetter.run();
            case "22", "L22" -> Lesson22Aggregation.run();
            case "23", "L23" -> Lesson23Composition.run();
            case "24", "L24" -> Lesson24WrapperClass.run();
            case "25", "L25" -> Lesson25ArrayList.run();
            case "26", "L26" -> Lesson26Exceptions.run();
            case "27", "L27" -> Lesson27FileWriteRead.run();
            case "28", "L28" -> Lesson28DateAndTime.run();
            case "29", "L29" -> Lesson29AnonymousClass.run();
            case "30", "L30" -> Lesson30Schedule.run();
            case "31", "L31" -> Lesson31Generics.run();
            case "32", "L32" -> Lesson32Hashmap.run();
            case "33", "L33" -> Lesson33Enums.run();
            case "34", "L34" -> Lesson34Threading.run();
            case "35", "L35" -> Lesson35MultiThreading.run();
            case "36", "L36" -> Lesson36ExecutorService.run();
            default -> {
                System.out.println("Unknown lesson code: " + code);
                System.out.println("Use number (like 0, 4) or L{number} (like L01, L04)");
            }
        }
    }
}