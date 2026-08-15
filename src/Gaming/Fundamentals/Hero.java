package Gaming.Fundamentals;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Hero {
    private static final int STEP = 20;

    private final int maxX;
    private final int maxY;
    private int x;
    private int y;
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
        this.x = maxX / 2;
        this.y = maxY / 2;
    }

    public void moveLeft() {
        x = Math.max(0, x - STEP);
    }

    public void moveRight() {
        x = Math.min(maxX, x + STEP);
    }

    public void moveUp() {
        y = Math.max(0, y - STEP);
    }

    public void moveDown() {
        y = Math.min(maxY, y + STEP);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getSprite() {
        return sprite;
    }
}
