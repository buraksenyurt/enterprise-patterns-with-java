public class Rgb {
    private int r;
    private int g;
    private int b;

    public Rgb(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Rgb{" +
                "r=" + r +
                ", g=" + g +
                ", b=" + b +
                '}';
    }
}
