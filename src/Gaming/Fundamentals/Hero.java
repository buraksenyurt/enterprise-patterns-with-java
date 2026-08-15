package Gaming.Fundamentals;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Hero {
    private int position;
    private int width;
    private BufferedImage sprite;

    public Hero(int width) {
        this.width = width;
        this.position = width / 2;

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
    }

    public void moveLeft() {
        if (position > 0) {
            position--;
        }
    }

    public void moveRight() {
        if (position < width - 1) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public BufferedImage getSprite() {
        return sprite;
    }
}
