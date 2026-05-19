import java.util.Scanner;

public class Lesson09EnhancedSwitch {
    public static void run() {
        System.out.println("Basit bir hesap makinesi (Enhanced Switch kullanır)");

        Scanner scanner = new Scanner(System.in);

        System.out.println("İşlem seçiniz +, -, *, /, ^");
        char symbol = scanner.next().charAt(0);
        if (symbol == '+' || symbol == '*' || symbol == '-' || symbol == '/' || symbol == '^') {
            System.out.println("İlk sayı ");
            double num1 = scanner.nextDouble();

            System.out.println("İkinci sayı ");
            double num2 = scanner.nextDouble();

            double result = 0;
            boolean isException = false;

            switch (symbol) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> {
                    if (num2 == 0) {
                        System.out.println("Bölen sıfır olmamalı. (Divide by zero exception)");
                        isException = true;
                    } else {
                        result = num1 / num2;
                    }
                }
                case '^' -> result = Math.pow(num1, num2);
            }

            if (!isException) {
                System.out.printf("%.2f %c %.2f = %.2f\n", num1, symbol, num2, result);
            } else {
                System.out.println("İşlemde hata var");
            }
        } else {
            System.out.println("Geçersiz operatör");
        }
        scanner.close();
    }
}
