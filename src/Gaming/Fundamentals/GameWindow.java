package Gaming.Fundamentals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameWindow extends JPanel {
    private final List<Drawable> drawables = new ArrayList<>();
    private final Set<Integer> pressedKeys = new HashSet<>();

    public GameWindow(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
    }

    public void addDrawable(Drawable drawable) {
        drawables.add(drawable);
    }

    public void trackKey(int keyCode) {
        String pressedName = "pressed-" + keyCode;
        String releasedName = "released-" + keyCode;

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyCode, 0, false), pressedName);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyCode, 0, true), releasedName);

        getActionMap().put(pressedName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedKeys.add(keyCode);
            }
        });
        getActionMap().put(releasedName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedKeys.remove(keyCode);
            }
        });
    }

    public boolean isKeyPressed(int keyCode) {
        return pressedKeys.contains(keyCode);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        for (Drawable drawable : drawables) {
            drawable.draw(g2);
        }
    }
}
