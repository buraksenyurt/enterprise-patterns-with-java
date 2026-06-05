import java.util.Scanner;

public class Lesson07StringMembers {
    public static void run() {
        // Some useful String methods

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir şeyler söyle. Eğer gizli kelimeyi söylersen sana bir süprizim var.");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Hiçbir şey girmedin. Ben bir şeyler yazayım.");
            input = "Hava çok güzel. Hadi dışarı çıkalım.";
        }

        if (input.equals("P@ssw0rd")) {
            System.out.println("İşte bu. Sihirli kelime. Super Mario oyununda %20 indirim kazandın.");
        }

        int length = input.length();
        char lastChar = input.charAt(length - 1);
        System.out.println("Girilen ifadenin son karakteri " + lastChar);
        if (input.contains(" ")) {
            System.out.println("Girdiğin ifade de boşluk karakterleri var.");
            int firstSpace = input.indexOf(' ');
            int lastSpace = input.lastIndexOf(' ');
            System.out.printf("İlk görüldüğü yer %d, Son görüldüğü yer %d\n", firstSpace, lastSpace);
        }

        String upperInput = input.toUpperCase();
        System.out.println(upperInput);

        String adminMail = "john.doe@jworld.none.com";
        String adminUserName = adminMail.substring(0, adminMail.indexOf("@"));
        System.out.printf("Herhangi bir sorunda `%s` (%s) adresine mail atabilirsin", adminUserName, adminMail);

        scanner.close();

    }
}
