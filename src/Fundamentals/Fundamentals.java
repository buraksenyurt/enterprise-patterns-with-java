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
        System.out.print("Select lesson ");

        int selection = scanner.nextInt();
        runByCode(String.valueOf(selection));
        scanner.close();
    }

    private static void runByCode(String code) throws InterruptedException {
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
            case "8":
            case "L08":
                Lesson08LengthConverter.run();
                break;
            case "9":
            case "L09":
                Lesson09EnhancedSwitch.run();
                break;
            case "10":
            case "L10":
                Lesson10PasswordChecker.run();
                break;
            case "11":
            case "L11":
                Lesson11GuessTheNumberAgain.run();
                break;
            case "12":
            case "L12":
                Lesson12Loops.run();
                break;
            case "13":
            case "L13":
                Lesson13Methods.run();
                break;
            case "14":
            case "L14":
                Lesson14Arrays.run();
                break;
            case "15":
            case "L15":
                Lesson15SceneCreator.run();
                break;
            case "16":
            case "L16":
                Lesson16Objects.run();
                break;
            case "17":
            case "L17":
                Lesson17Static.run();
                break;
            case "18":
            case "L18":
                Lesson18Inheritance.run();
                break;
            case "19":
            case "L19":
                Lesson19AbstractClass.run();
                break;
            case "20":
            case "L20":
                Lesson20Interface.run();
                break;
            case "21":
            case "L21":
                Lesson21GetterSetter.run();
                break;
            case "22":
            case "L22":
                Lesson22Aggregation.run();
                break;
            case "23":
            case "L23":
                Lesson23Composition.run();
                break;
            case "24":
            case "L24":
                Lesson24WrapperClass.run();
                break;
            case "25":
            case "L25":
                Lesson25ArrayList.run();
                break;
            case "26":
            case "L26":
                Lesson26Exceptions.run();
                break;
            case "27":
            case "L27":
                Lesson27FileWriteRead.run();
                break;
            case "28":
            case "L28":
                Lesson28DateAndTime.run();
                break;
            case "29":
            case "L29":
                Lesson29AnonymousClass.run();
                break;
            case "30":
            case "L30":
                Lesson30Schedule.run();
                break;
            case "31":
            case "L31":
                Lesson31Generics.run();
                break;
            case "32":
            case "L32":
                Lesson32Hashmap.run();
                break;
            case "33":
            case "L33":
                Lesson33Enums.run();
                break;
            default:
                System.out.println("Unknown lesson code: " + code);
                System.out.println("Use number (like 0, 4) or L{number} (like L01, L04)");
                break;
        }
    }
}