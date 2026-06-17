package com.example.gamerental.domain.game;

// Aggregate root olarak ele aldığımız Game sınıfı. 
// Oyun kataloğundaki bir oyunu temsil eder.
public class Game {
    private GameId id;
    private String title;
    private Platform platform;
    private int totalCopies;
    private int availableCopies;

    // Constructor metodumuz bilerek private yapılmıştır.
    // Game nesnesini oluşturmak için bir factory method kullanacağız.
    private Game(GameId id, String title, Platform platform, int totalCopies, int availableCopies) {
        // Bazı kontroller ekledik.
        // Örneğin, title boş olamaz, totalCopies 1'den küçük olamaz ve
        // availableCopies totalCopies'tan büyük olamaz gibi.
        // Böylece, anlamsız bir Game nesnesi oluşturulmasını engellemiş oluyoruz.
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (totalCopies < 1) {
            throw new IllegalArgumentException("Total copies must be at least 1");
        }
        if (availableCopies < 0 || availableCopies > totalCopies) {
            throw new IllegalArgumentException("Available copies must be between 0 and total copies");
        }

        this.id = id;
        this.title = title;
        this.platform = platform;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    // Yeni bir oyun kataloğa eklenmek istendiğinde kullanılacak factory metot.
    public static Game register(String title, Platform platform, int totalCopies) {
        GameId id = GameId.newId(); // Yeni bir GameId oluşturuyoruz.
        // Kataloğa ilk kez eklenen bir oyun olduğu için availableCopies, totalCopies
        // ile aynıdır
        return new Game(id, title, platform, totalCopies, totalCopies);
    }

    // Bu da bir factory metoddur. Sistemde zaten var olan bir oyun nesnesinin
    // envanter
    // durumunu yeniden oluşturmak için kullanılabilir.
    public static Game reconstitute(GameId id, String title, Platform platform, int totalCopies, int availableCopies) {
        return new Game(id, title, platform, totalCopies, availableCopies);
    }

    // Oyun kiralanmak istendiğinde kullanılacak metot.
    // Eğer kiralanmak istenen oyunun kopyası mevcut değilse,
    // NoCopyAvailableException fırlatılır.
    // Eğer kopya mevcutsa, availableCopies bir azaltılır.
    public void rentOneCopy() {
        if (availableCopies <= 0) {
            throw new NoCopyAvailableException(id);
        }
        availableCopies--;
    }

    // Oyun iade edilmek istendiğinde kullanılacak metot.
    // Eğer iade edilmek istenen oyunun kopyası zaten envanterde mevcutsa,
    // IllegalStateException fırlatılır.
    // Eğer kopya mevcut değilse, availableCopies bir artırılır.
    public void returnOneCopy() {
        if (availableCopies >= totalCopies) {
            throw new IllegalStateException("All copies are already returned for " + id.value());
        }
        availableCopies++;
    }

    // Getter metodları
    public GameId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }
}
