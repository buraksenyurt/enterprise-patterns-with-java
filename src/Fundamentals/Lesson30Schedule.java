import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Lesson30Schedule {
    public static void run() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of seconds you want to countdown: ");
        int seconds = input.nextInt();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int counter = seconds;

            @Override
            public void run() {
                System.out.println("counting... " + counter);
                counter--;
                if (counter < 0) {
                    System.out.println("Initiation...We are going to Mars! :D");
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);

        input.close();
    }
}
