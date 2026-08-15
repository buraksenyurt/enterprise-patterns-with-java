package Gaming.Fundamentals;

/*
    Bu örnekte ise swing kütüphanesini kullanarak çok temel bazı işlemleri ele alıyoruz.
    Ekrana bir karakter yerleştirme ve yön tuşları ile hareket ettirme.

    Ancak bunu yaparken uygulamaya çalıştığımız bazı teknikler de var.
    Örneğin Delta Time hesabı, ekrana çizilmesi gereken nesneler için Drawable arayüzü, 
    tuş takibi için Key Bindings kullanımı gibi.
*/

public class Main {
    public static void main(String[] args) {
        Game game = new Game(800, 600);
        game.start();
    }
}
