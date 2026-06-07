import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lesson36ExecutorService {
    public static void run() {
        /*
         * C# tarafındaki Thread Pool veya modern Task Paralel Library yapısına benzer
         * şekilde Java tarafında da ExecutorService yapısı kullanılabilir.
         * Örnek olarak farklı mikro servisler üzerinde health check işlemi yapan bir
         * multithread mekanizma geliştirebiliriz.
         */

        String[] services = { "Auth Service", "Order Service", "Inventory Service", "Payment Service",
                "Notification Service", "User Service", "Analytics Service", "Search Service" };

        // Aynı anda en fazla 4 thread çalışacak şekilde bir havuz oluşturuyoruz
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (String service : services) {
            executor.submit(new ServiceHealthCheckRunnable(service)); // Task.Run() karşılığı gibi düşünebiliriz.
        }

        executor.shutdown(); // Havuzun yeni görev kabul etmesini engelliyoruz, mevcut görevler ise çalışmaya
                             // devam edecektir.

        try {
            System.out.println("Servisler kontrol ediliyor...");

            // Tüm görevlerin 10 saniye içinde tamamlanmasını bekliyoruz. Eğer bu süre
            // zarfında tamamlanmazsa, zaman aşımı mesajı vereceğiz.
            boolean finished = executor.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS);

            if (finished) {
                System.out.println("Tüm sağlık kontrolleri tamamlandı.");
            } else {
                System.err.println("Bazı sağlık kontrolleri zaman aşımına uğradı.");
            }

        } catch (InterruptedException e) {
            System.err.println("Ana thread kesintiye uğradı.");
        }
    }
}
