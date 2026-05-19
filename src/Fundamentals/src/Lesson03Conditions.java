import java.util.Random;
import java.util.Scanner;

public class Lesson03Conditions {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bana adını söyler misin? ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Tekrar gel. İsmini öğrenmeden ilerlemek istemem");
            return;
        }

        IO.println("Hoşgeldin " + name);

        IO.println("Hangi yöne gitmek istersin (Kuzey, Güney, Doğu, Batı)? ");
        String line = scanner.nextLine().toUpperCase();
        char direction = line.charAt(0);

        if (direction == 'K') {
            IO.println("Kuzeye gidiyoruz");
        } else if (direction == 'G') {
            IO.println("Güneye gidiyoruz. Tatill!!!");
        } else if (direction == 'B') {
            IO.println("Güneşin battığı yöne gidiyoruz");
        } else if (direction == 'D') {
            IO.println("Hadi güneşin doğuşunu izlemeye gidelim");
        } else {
            IO.println("Hangi yöne gideceğimi bilemedim şimdi. Duralım.");
        }

        // Nested If blocks sample
        Random random = new Random();

        boolean isSubscriber = random.nextBoolean();
        boolean hasGoldenTicket = random.nextBoolean();
        if (isSubscriber) {
            if (hasGoldenTicket) {
                System.out.println("%5 indirim kazandın");
            } else {
                System.out.println("%1 indirim kazandın");
            }
        } else {
            System.out.println("Herhangi bir indirim yok");
        }


        switch (direction) {
            case 'K':
                System.out.println("North");
                break;
            case 'G':
                System.out.println("South");
                break;
            case 'B':
                System.out.println("West");
                break;
            case 'D':
                System.out.println("East");
                break;
            default:
                System.out.println("Unknown");
                break;
        }

        // Ternary :? operator
        int graduatePoint = random.nextInt(10, 100);
        String result = graduatePoint > 70 ? "PASS" : "FAIL";
        System.out.println("Sınav sonucu : " + result);

        int hours = random.nextInt(0, 24);
        String timeOfDay = (hours < 12) ? "A.M." : "P.M";
        System.out.println("Saat " + hours + " " + timeOfDay);
    }
}
