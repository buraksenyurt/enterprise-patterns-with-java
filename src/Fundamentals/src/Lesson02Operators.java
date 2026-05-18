import java.util.Scanner;

public class Lesson02Operators {
    public static void run() {
        int x = 10;
        int y = 2;
        int z = 3;

        int sum = x + y + z;
        IO.println(sum);

        int module = x % z;
        IO.println(module);

        x *= z;
        IO.println(x);

        double a = 10;
        double b = 3;
        double c = a / b;
        IO.println(c);

        int luckyNumber = 22;
        luckyNumber++;
        IO.println(luckyNumber);

        Scanner scanner = new Scanner(System.in);
        String item = "Cizzborgır";
        double price;
        int quantity;
        double total;

        System.out.println("Ne yemek istersin? ");
        item = scanner.next();
        System.out.println("Kaç liran var? ");
        price = scanner.nextDouble();
        System.out.println("Kaç tane alacaksın?");
        quantity = scanner.nextInt();
        total = price * quantity;

        System.out.println("Sipariş Özeti");
        System.out.println("` " + item + "`, (" + quantity + " adet)");
        System.out.println("Toplam tutar " + total);
    }
}
