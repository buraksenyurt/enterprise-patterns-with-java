package Gaming.Fundamentals;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Hero implements Drawable {
    private static final double SPEED = 200;

    private final double maxX;
    private final double maxY;
    private double x;
    private double y;
    private BufferedImage sprite;

    public Hero(int windowWidth, int windowHeight) {
        try {
            InputStream in = Hero.class.getResourceAsStream("Hero.png");
            if (in == null) {
                throw new IOException("Hero.png not found on classpath");
            }
            sprite = ImageIO.read(in);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load Hero.png", e);
        }

        this.maxX = windowWidth - sprite.getWidth();
        this.maxY = windowHeight - sprite.getHeight();
        // this.x = maxX / 2;
        this.y = maxY / 2;
    }

    public void moveLeft(double deltaSeconds) {
        x = Math.max(0, x - SPEED * deltaSeconds);
    }

    public void moveRight(double deltaSeconds) {
        x = Math.min(maxX, x + SPEED * deltaSeconds);
    }

    public void moveUp(double deltaSeconds) {
        y = Math.max(0, y - SPEED * deltaSeconds);
    }

    public void moveDown(double deltaSeconds) {
        y = Math.min(maxY, y + SPEED * deltaSeconds);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(sprite, (int) Math.round(x), (int) Math.round(y), null);
    }
}
