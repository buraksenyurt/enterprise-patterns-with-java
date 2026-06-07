public class ServiceHealthCheckRunnable implements Runnable {
    private final String serviceName;

    public ServiceHealthCheckRunnable(String serviceName) {
        this.serviceName = serviceName;
    }
    /*
     * Sembolik olarak bir mikro servis sağlığı kontrolü yapan bir Runnable sınıfı
     * oluşturduk.
     * Gerçek dünyada bu, bir HTTP isteği yaparak veya bir veritabanı bağlantısı
     * kurarak gerçekleştirilebilir.
     * ÖRnekte rastgele bir gecikme ve yanıt durumu oluşturuyoruz. Bazen hata
     * veriyor bazen OK dönüyor.
     */

    @Override
    public void run() {
        System.out.println(
                "Sağlık kontrolü başlatıldı: " + serviceName + ". Thread: " + Thread.currentThread().getName());
        try {
            // 500ms ile 2000ms arasında rastgele gecikme taklidi
            int pingLatency = (int) (Math.random() * 1500) + 500;
            Thread.sleep(pingLatency);

            if (pingLatency > 1750) {
                System.out.println(
                        "[WARNING] " + serviceName + " servisi yanıt vermiyor. Gecikme: " + pingLatency + "ms");
            } else {
                System.out
                        .println("[OK] " + serviceName + " ayakta ve çalışır durumda. Gecikme: " + pingLatency + "ms");
            }
        } catch (InterruptedException e) {
            System.out.println("İşlem iptal edildi: " + serviceName);
            Thread.currentThread().interrupt();
        }
    }

}
