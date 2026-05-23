public class Chrono {
    int hour;
    int minute;
    int second;

    public Chrono(int hour, int minute, int second) {
        if (!validate(hour, minute, second))
            throw new IllegalArgumentException("Hour or Minute or Second Invalid");

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Chrono(int hour, int minute) {
        this(hour, minute, 0);
    }

    public Chrono(int hour) {
        this(hour, 0, 0);
    }

    boolean validate(int hour, int minute, int second) {
        return (hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 59)
                && (second >= 0 && second <= 59);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }
}
