public class Chronable implements Runnable {

    private int durationInSeconds;

    public Chronable(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public Chronable() {
        this.durationInSeconds = 10;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    @Override
    public void run() {
        for (int i = 0; i < durationInSeconds; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Timer interrupted...");
                return;
            }

            if (i == durationInSeconds - 1) {
                System.out.println("\nYour time is up!");
            }
        }
    }
}
