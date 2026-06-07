import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Lesson34Threading {
    public static void run() {

        HashMap<String, String> questionsAndAnswers = new HashMap<>();

        questionsAndAnswers.put("What is the first 3 digits of pi?", "3.14");
        questionsAndAnswers.put("What is the capital of `Monaco`?", "Monaco");
        questionsAndAnswers.put("What is the most important thing of Quantum Programming?", "Qubits");

        Random random = new Random();
        int idx = random.nextInt(questionsAndAnswers.size());
        String question = (String) questionsAndAnswers.keySet().toArray()[idx];
        String answer = questionsAndAnswers.get(question);

        Scanner scanner = new Scanner(System.in);

        // Create and start the timer thread (Second thread)
        Chronable chronable = new Chronable(20);
        Thread timerThread = new Thread(chronable);
        timerThread.setDaemon(true); // Program will exit when main thread finishes, even if timerThread is still
                                     // running
        timerThread.start();

        System.out
                .println("You have " + chronable.getDurationInSeconds() + " seconds to answer the following question:");
        System.out.println(question);
        String userAnswer = scanner.nextLine();
        if (userAnswer.equalsIgnoreCase(answer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("The correct answer is: " + answer);
        }

        scanner.close();
        // timerThread.interrupt();
    }
}
