/*
    Enum türü yapıcı metot(constructor) içerebilir ve sabit değerlere farklı türler atayabiliriz.
    Rust tarafındaki enum yapısını hatırlattı gibi ama oradaki kullanımının daha zengin olduğunu düşünüyorum.
*/
public enum ThemeColor {

    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    YELLOW(255, 255, 0),
    ORANGE(255, 165, 0),
    PURPLE(128, 0, 128),
    BLACK(0, 0, 0),
    WHITE(255, 255, 255);

    private final Rgb rgb;

    ThemeColor(int r, int g, int b) {
        this.rgb = new Rgb(r, g, b);
    }

    public Rgb getRgb() {
        return rgb;
    }
}