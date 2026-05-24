public class Lesson29AnonymousClass {
    public static void run() {
        /*
        Genellikle var olan bir sınıfın türetilmiş yeni bir örneğini oluşturmadan,
        ona yeni davranışlar kazandırmak amacıyla kullanılabilir.
        TimerTask, Runnable, callbacks gibi konularda da geçer.

        İlk örnekte PaymentProcess'ün process metodunu değiştiriyoruz ama yeni bir sınıf yazmadan,
        anonymous class kullanarak.

        İkinci örnek ise event bazlı bir örneği ele alıyor. Bir event tetiklendiğinde
        devreye girecek callback fonksiyonunu anonim sınıflar kullanarak nasıl çağırabileceğimizi görüyoruz.

        */
        PaymentProcessor standardPayment = new PaymentProcessor();
        standardPayment.process(1000);

        // Anlık olarak kod içerisinde davranış değiştirme
        PaymentProcessor discountedPayment = new PaymentProcessor() {
            @Override
            public void process(double amount) {
                double discountAmount = amount * 0.8;
                System.out.println("Discount amount: " + discountAmount);
            }
        };

        discountedPayment.process(1000);

        ButtonElement submitButton = new ButtonElement("btnSave", "Save to file");
        /*
            setOnClickListener, ClickEventListener interface'ini kullanır ama normalde
            interface'lerden nesne örneklenemez.
            Anonymous sınıf olarak ele alıp OnClick metodunu yazabiliriz.
            Hatta bu on the fly metot gövdesi oluşturmak olarak da ifade ediliyor.
         */
//        submitButton.setOnClickListener(new ClickEventListener() {
//            @Override
//            public void OnClick() {
//                System.out.println("Button clicked");
//            }
//        });
        // Yukarıdaki kullanımı lambda versiyonu ile daha basit yazabiliriz
        submitButton.setOnClickListener(() -> System.out.println("Button clicked"));
    }
}

class PaymentProcessor {
    public void process(double amount) {
        System.out.println("Processing Payment, " + amount);
    }
}

interface ClickEventListener {
    void OnClick();
}

class ButtonElement {
    private String id;
    public String title;

    public ButtonElement(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setOnClickListener(ClickEventListener listener) {
        listener.OnClick();
    }
}
