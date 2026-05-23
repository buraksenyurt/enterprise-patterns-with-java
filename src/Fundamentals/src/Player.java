public class Player {
    int id;
    String name;
    double point;

    Player(int id, String name, double point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPoint() {
        return point;
    }
}
