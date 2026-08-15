package Gaming.Fundamentals;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel {
    private int gridWidth;
    private int gridHeight;
    private Hero hero;

    public GameWindow(int width, int height) {
        this.gridWidth = width;
        this.gridHeight = height;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (hero != null && hero.getSprite() != null) {
            Image sprite = hero.getSprite();
            int x = (getWidth() - sprite.getWidth(this)) / 2;
            int y = (getHeight() - sprite.getHeight(this)) / 2;
            g2.drawImage(sprite, x, y, this);
        }
    }
}
