package Gaming.Fundamentals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GameWindow extends JPanel {
    private int gridWidth;
    private int gridHeight;
    private Hero hero;

    public GameWindow(int width, int height) {
        this.gridWidth = width;
        this.gridHeight = height;
        setupKeyBindings();
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

    private void setupKeyBindings() {
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        bindMovement(inputMap, actionMap, KeyEvent.VK_LEFT, "moveLeft", () -> hero.moveLeft());
        bindMovement(inputMap, actionMap, KeyEvent.VK_RIGHT, "moveRight", () -> hero.moveRight());
        bindMovement(inputMap, actionMap, KeyEvent.VK_UP, "moveUp", () -> hero.moveUp());
        bindMovement(inputMap, actionMap, KeyEvent.VK_DOWN, "moveDown", () -> hero.moveDown());
    }

    private void bindMovement(InputMap inputMap, ActionMap actionMap, int keyCode, String name, Runnable action) {
        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0), name);
        actionMap.put(name, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hero != null) {
                    action.run();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (hero != null && hero.getSprite() != null) {
            g2.drawImage(hero.getSprite(), hero.getX(), hero.getY(), this);
        }
    }
}
