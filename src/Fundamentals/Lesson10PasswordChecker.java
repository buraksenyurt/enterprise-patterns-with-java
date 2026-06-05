import java.util.Scanner;

public class Lesson10PasswordChecker {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        boolean passwordOk = false;
        int counter = 0;
        String password = "";

        while (!passwordOk) {
            if (counter == 3) {
                System.out.println("Toplamda 3 denemede kurallara uygun şifre oluşmadı. Ben oluşturacağım");
                break;
            }
            counter++;

            System.out.println("Lütfen bir şifre girin");
            password = scanner.nextLine();

            if (password.length() < 7 || password.length() > 20) {
                System.out.println("Şifre 7 ile 20 karakter arasında olmalı.");
                continue;
            } else if (password.contains(" ") || password.contains("_")) {
                System.out.println("Şifrede boşluk veya _ karakteri olmamalıdır");
                continue;
            }
            /*
                Kurallara göre karakter kontrolleri gelebilir.
                En az bir büyük harf olsun, en az 4 sayı içersin,
                @ ve ! gibi karakterlerden en an birisini içersin vs gibi
            */
            passwordOk = true;
        }

        if (passwordOk) {
            System.out.printf("Belirlenen şifre; '%s'\n", password);
        }
        scanner.close();
    }
}
