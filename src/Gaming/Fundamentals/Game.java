package Gaming.Fundamentals;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Game {
    private static final int TARGET_FPS = 60;
    private static final long FRAME_TIME_NS = 1_000_000_000L / TARGET_FPS;
    private static final double MAX_DELTA_SECONDS = 0.05;

    private final GameWindow window;
    private final Hero hero;

    public Game(int width, int height) {
        this.window = new GameWindow(width, height);
        this.hero = new Hero(width, height);

        window.addDrawable(hero);
        window.trackKey(KeyEvent.VK_LEFT);
        window.trackKey(KeyEvent.VK_RIGHT);
        window.trackKey(KeyEvent.VK_UP);
        window.trackKey(KeyEvent.VK_DOWN);
    }

    public void start() {
        SwingUtilities.invokeLater(this::createAndShowWindow);
        runLoop();
    }

    private void createAndShowWindow() {
        JFrame frame = new JFrame("Fundamentals - Hello Swing");

        frame.add(window);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void runLoop() {
        long lastFrameTime = System.nanoTime();

        while (true) {
            long frameStart = System.nanoTime();
            double deltaSeconds = Math.min((frameStart - lastFrameTime) / 1_000_000_000.0, MAX_DELTA_SECONDS);
            lastFrameTime = frameStart;

            update(deltaSeconds);
            render();

            long sleepNanos = FRAME_TIME_NS - (System.nanoTime() - frameStart);
            if (sleepNanos > 0) {
                try {
                    Thread.sleep(sleepNanos / 1_000_000, (int) (sleepNanos % 1_000_000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    private void update(double deltaSeconds) {
        if (window.isKeyPressed(KeyEvent.VK_LEFT)) {
            hero.moveLeft(deltaSeconds);
        }
        if (window.isKeyPressed(KeyEvent.VK_RIGHT)) {
            hero.moveRight(deltaSeconds);
        }
        if (window.isKeyPressed(KeyEvent.VK_UP)) {
            hero.moveUp(deltaSeconds);
        }
        if (window.isKeyPressed(KeyEvent.VK_DOWN)) {
            hero.moveDown(deltaSeconds);
        }
    }

    private void render() {
        window.repaint();
    }
}
