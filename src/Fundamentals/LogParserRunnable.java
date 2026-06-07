// Bu sınıf bir log dosyasını ayrıştırma işlemini simüle eder.
// Runnable arayüzünü uygulayarak, bu sınıfın bir thread içinde çalıştırılması sağlanır.

public class LogParserRunnable implements Runnable {

    private String logFilePath;

    public LogParserRunnable(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    @Override
    public void run() {
        System.out.println(logFilePath + " parse işlemi başlatıldı.");
        try {
            // Uzun süren bir işlem olduğunu simüle etmek için rastgele bir süre uyutuyoruz.
            Thread.sleep((long) (Math.random() * 5000) + 1000);
        } catch (InterruptedException e) {
            System.err.println(logFilePath + " parse işlemi kesildi.");
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println(logFilePath + " parse işlemi tamamlandı.");
    }

}
