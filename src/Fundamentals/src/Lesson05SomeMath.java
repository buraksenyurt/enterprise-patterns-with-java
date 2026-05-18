import java.util.Scanner;

public class Lesson05SomeMath {
    public static void run(){

        // Some Math constants
        System.out.println("PI değeri " + Math.PI);
        System.out.println("e değeri " + Math.E);

        double result;

        result = Math.pow(2,10);
        System.out.println("2 Qubit bilgisayar aynı anda " + result + " hesaplama yapabilir");
        System.out.println("-7 nin mutlak değeri " + Math.abs(-5));
        System.out.println("16nın kare kökü " + Math.sqrt(16));
        System.out.println("20 ve 17 değerlerinden maksimum olanı " + Math.max(20,17));
        System.out.println("20 ve 17 değerlerinden minimum olanı " + Math.min(20,17));
        System.out.println("PI değerini yukarı yuvarladık(Ceil) " + Math.ceil(Math.PI));
        System.out.println("PI değerini aşağı yuvarladık(Floor) " + Math.floor(Math.PI));
        System.out.println("2.49 değerini (round) " + Math.round(2.49));

        // Find Hypotenuse
        Scanner scanner = new Scanner(System.in);
        double x;
        double y;
        double h;
        System.out.println("x kenarı uzunluğu? ");
        x = scanner.nextDouble();
        System.out.println("y kenarı uzunluğu? ");
        y = scanner.nextDouble();
        h = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        System.out.println("Hipotenüs değeri = " + h);

        // Find Circle Square, Circumference
        double radius;
        double circumference;
        double area;
        double volume;
        System.out.println("Daire yarıçap nedir? ");
        radius = scanner.nextDouble();
        circumference = 2 * Math.PI * radius;
        area = Math.PI * Math.pow(radius, 2);
        volume = (4 / 3.0) * Math.PI * Math.pow(radius, 3);
        System.out.printf("Dairenin çevresi %.2f\n", circumference);
        System.out.printf("Dairenin alanı %.2f\n",area);
        System.out.printf("Küre olursa hacmi %.2f\n", volume);

        scanner.close();

    }
}
