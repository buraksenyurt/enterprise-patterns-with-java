package Gaming.HearthRider;

/*
    Bu örnekte çok basit bir oyun döngüsü ve state yönetimi ele alınıyor.
    Sonsuz döngü içerisinde ana thread'in belli süre uyutulmasına göre oyun hızı kontrol edilip,
    frame bazlı bir şekilde state değişikliği ve render işlemi yapılıyor.

    Oyun döngüleri genelerde iki ana işi yapar:
    1. Update: Oyun sahasındaki karakterlerin ve objelerin durumları yönetilir, yani state değişikliği yapılır
    2. Render: Değişiklikler sonrasıda nesneler yeni state'lerine göre ekrana çizilir, yani render işlemi yapılır

    Bu programı çalıştırdığımızda görmemiz gereken şey, 
    bir kalp sembolünün (❤ - ki Unicode karşılığını kullandık) ekranın solundan sağına doğru hareket etmesi 
    ve ekranın sağ kenarına ulaştığında geri dönmesidir.

    Klasör adı zamanın Michael Knight'ın arabası KITT'ten esinlenerek "HearthRider" olarak seçilmiştir.
*/
public class Main {
    private static final int WIDTH = 40;
    private static final long TICK_MS = 100;

    public static void main(String[] args) throws InterruptedException {
        int position = 0;
        int direction = 1;

        while (true) {
            // 1. Update: State değişikliği yapılıyor
            position += direction;
            if (position <= 0 || position >= WIDTH - 1) {
                direction *= -1;
            }

            // 2. Render: Mevcut durum çiziliyor
            render(position);

            // 3. Wait: Ana thread belli süre uyutuluyor ve böylece oyun hızı kontrol
            // ediliyor
            Thread.sleep(TICK_MS);
        }
    }

    private static void render(int position) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < WIDTH; i++) {
            line.append(i == position ? '\u2764' : ' ');
        }
        // \r satır başına geri sarıyor, böylece her kare bir öncekinin üzerine yazıyor
        System.out.print("\r" + line);
        System.out.flush();
    }
}
