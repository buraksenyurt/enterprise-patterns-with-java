public class Lesson18Inheritance {
    public static void run() {
        var button = new Button(1, "Save Fie", 200, 25);
        button.draw();
        button.setText("Save File");
        button.draw();

        var linkButton = new LinkButton(2, "Google");
        linkButton.setUrl("https://www.google.com");
        linkButton.draw();
        linkButton.onClick();

        Control[] controls = {button, linkButton, new Button(3, "Exit", 200, 25)};
        for (Control control : controls) {
            control.draw();
            System.out.println("Current control id is " + control.getId());
        }

        Control grid = new Grid(4, 6);
        grid.draw(); // Calls override method. A simple polymorphism
    }
}

class Control {
    int id;

    void draw() {
        System.out.println("Drawing..." + this);
    }

    int getId() {
        return id;
    }
}

class Button extends Control {
    String text;
    int width;
    int height;

    Button(int id, String text, int width, int height) {
        super.id = id;
        this.text = text;
        this.width = width;
        this.height = height;
    }

    void setText(String text) {
        this.text = text;
    }
}

class LinkButton extends Button {
    String url;

    LinkButton(int id, String text) {
        super(id, text, 100, 10);
    }

    void setUrl(String url) {
        this.url = url;
    }

    void onClick() {
        System.out.println("Going to " + this.url);
    }
}

class Grid extends Control {
    int rows;
    int cols;

    Grid(int rows, int cols) {
        super.id = 0; // Maybe we can use GUID on super class
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    void draw() {
        System.out.println("Drawing Grid with " + this.rows + " rows and " + this.cols + " cols");
    }
}
