import java.util.ArrayList;

public class Lesson24WrapperClass {
    public static void run() {
        // Primitive değelerin birer object olarak kullanılması olarak düşünülebilir

        // Autoboxing
        Integer number = 23; // Primitive doğrudan nesne örneğine dönüşür
        Character letter = 'B';
        Boolean flag = true;

        // Unboxing
        int n = number; // Wrap edilmiş bir nesneyi primitive'e dönüştürmek

        // Java içinde Utility olarak kullanılan birçok wrapper class vardır
        String luckyNumber = Integer.toString(number);
        String piStr = Double.toString(Math.PI);
        String isActive = Boolean.toString(flag);

        int yourGuess = Integer.parseInt(luckyNumber);
        boolean online = Boolean.parseBoolean(isActive);
        char firstChar = "It's a beautiful day".charAt(0);
        boolean isLetter = Character.isLetter(firstChar);
        System.out.println("Is first character upper case ? " + Character.isUpperCase(firstChar));
        System.out.println("is $ char is a letter ? " + Character.isLetter('$'));

        // ArrayList'ler de Wrapper class'lar ile generic hale getirilebilir
        ArrayList<Integer> numbers = new ArrayList<>();
    }
}
