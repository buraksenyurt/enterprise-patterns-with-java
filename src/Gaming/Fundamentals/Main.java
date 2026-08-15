package Gaming.Fundamentals;
import javax.swing.*;
import java.awt.*;

/*
    Bu örnekte ise swing kütüphanesini kullanarak çok temel bazı işlemleri ele alıyoruz.
    Ekrana bir karakter yerleştirme ve yön tuşları ile hareket ettirme.

*/

public class Main {
    public static void main(String[] args) {
        int width = 1280;
        int height = 960;

        GameWindow window = new GameWindow(width, height);
        Hero hero = new Hero(width, height);
        window.setHero(hero);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Fundamentals - Hello Swing");

            window.setPreferredSize(new Dimension(width, height));
            window.setBackground(Color.BLACK);

            frame.add(window);
            frame.pack();
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        while (true) {
            window.repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
