import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson26Exceptions {
    public static void run() {
        // catchTheException();
        autoResourceManagement();
    }

    static void catchTheException() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter the first number ");
            int num1 = input.nextInt();
            System.out.println("Enter the second number ");
            int num2 = input.nextInt();
            double output = num1 / num2;
            System.out.printf("%d / %d = %f\n", num1, num2, output); // num2 0 olursa ArithmeticException fırlatır
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception " + e.getMessage());
        } catch (InputMismatchException e) { // Sayısal değer yerine metin girersek
            System.out.println("InputMismatchException " + e.getMessage());
        } catch (Exception e) { // Yukarıdakiler dışında bir exception oluşursa
            System.out.println("There is an error " + e.getMessage());
        } finally {
            input.close();
            System.out.println("Always works this block");
        }
    }

    static void autoResourceManagement() {
        try (Scanner input = new Scanner(System.in)) { // Scanner resource otomatik olarak temizlenir
            System.out.println("Enter the first number ");
            int num1 = input.nextInt();
            System.out.println("Enter the second number ");
            int num2 = input.nextInt();
            double output = num1 / num2;
            System.out.printf("%d / %d = %f\n", num1, num2, output);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException " + e.getMessage());
        } catch (Exception e) {
            System.out.println("There is an error " + e.getMessage());
        } finally {
            System.out.println("Always works this block");
        }
    }
}
