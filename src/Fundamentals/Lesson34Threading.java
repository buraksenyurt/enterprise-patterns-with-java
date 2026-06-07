import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Lesson34Threading {
    public static void run() {

        HashMap<String, String> questionsAndAnswers = new HashMap<>();

        questionsAndAnswers.put("Pi sayısının ilk 3 basamağı nedir?", "3.14");
        questionsAndAnswers.put("Monako'nun başkenti neresidir?", "Monako");
        questionsAndAnswers.put("Kuantum Programlamanın en önemli unsuru nedir?", "Qubits");

        Random random = new Random();
        int idx = random.nextInt(questionsAndAnswers.size());
        String question = (String) questionsAndAnswers.keySet().toArray()[idx];
        String answer = questionsAndAnswers.get(question);

        Scanner scanner = new Scanner(System.in);

        // Timer thread oluştur ve başlat (İkinci thread)
        Chronable chronable = new Chronable(20);
        Thread timerThread = new Thread(chronable);
        timerThread.setDaemon(true); // Program main thread sona erdiğinde, timerThread hala çalışıyor olsa bile programdan çıkılır. timerThread main thread sona erdiğinde sonlandırılır.
        timerThread.start();

        System.out
                .println("Cevaplamak için " + chronable.getDurationInSeconds() + " saniyeniz var:");
        System.out.println(question);
        String userAnswer = scanner.nextLine();
        if (userAnswer.equalsIgnoreCase(answer)) {
            System.out.println("Doğru!");
        } else {
            System.out.println("Doğru cevap: " + answer);
        }

        scanner.close();
        // timerThread.interrupt();
    }
}
