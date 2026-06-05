public class Lesson31Generics {
    public static void run() {
        Basket<Integer> basket = new Basket<>(10);
        basket.setItem(12);
        System.out.println(basket.getItem());

        Basket<String> fruitBasket = new Basket<>("Apple");
        System.out.println(fruitBasket.getItem());

        Pair<Integer, String> pair = new Pair<>(1, "Apple");
        System.out.println(pair);
        Pair<String, String> newPair = new Pair<>("Apple", "Elma");
        System.out.println(newPair);

        var r = findSuccess();
        System.out.println(r);

        r = findFailure();
        System.out.println(r);
    }

    // Result türünü new yerine statik ve duruma uygun (Success veya Failure) metotlarla üretiyoruz
    static Result<Double> findSuccess() {
        return Result.success(3.14);
    }

    static Result<Double> findFailure() {
        return Result.failure("Connection lost");
    }
}

class Basket<T> {
    T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public Basket(T item) {
        this.item = item;
    }
}

class Pair<T, U> {
    T key;
    U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + ": " + value;
    }
}

class Result<T> {
    private final T value;
    private final boolean success;
    private final String message;

    // Result<T> dışarıdan new ile oluşturulamaz.
    private Result(T value, boolean success, String message) {
        this.value = value;
        this.success = success;
        this.message = message;
    }

    // Başarılı sonuçlar için bir Static Factory metodu
    public static <T> Result<T> success(T value) {
        return new Result<>(value, true, null);
    }

    // Hata alınan durumları temsil etmek için bir Static Factory metodu
    public static <T> Result<T> failure(String message) {
        return new Result<>(null, false, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public T getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        if (success) {
            return "Success: (" + value + ")";
        } else {
            return "Error: " + message;
        }
    }
}