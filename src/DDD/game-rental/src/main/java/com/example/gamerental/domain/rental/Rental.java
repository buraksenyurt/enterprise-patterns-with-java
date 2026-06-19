package com.example.gamerental.domain.rental;

import java.time.LocalDate;
import java.util.Currency;

import com.example.gamerental.domain.game.GameId;
import com.example.gamerental.domain.shared.Money;

// Oyun kiralama işlerini temsil eden diğer Aggregate root sınıfımız.
// Kiralama işlemlerini ve kiralama ile ilgili iş kurallarını kapsar.
public class Rental {
    // Kiralama işlemi için geçerli olan para birimi ve günlük gecikme ücretini
    // temsil eden sabitler.
    private static final Currency TRY = Currency.getInstance("TRY");
    private static final Money DAILY_LATE_FEE = Money.of("2.5", "TRY");

    private final RentalId id;
    private final GameId gameId;
    private final MemberId memberId;
    private final LocalDate rentedOn;
    private final LocalDate dueOn;
    private LocalDate returnedOn;
    private RentalStatus status;
    private Money lateFee;

    // Kiralama işlemi için private bir constructor. Nesne oluşturma işini dış
    // dünyaya kapattık
    // ve aynen Game sınıfında olduğu gibi, nesne oluşturmak için factory methodlar
    // kullanacağız.
    private Rental(RentalId id, GameId gameId, MemberId memberId, LocalDate rentedOn, LocalDate dueOn,
            LocalDate returnedOn, RentalStatus status, Money lateFee) {
        this.id = id;
        this.gameId = gameId;
        this.memberId = memberId;
        this.rentedOn = rentedOn;
        this.dueOn = dueOn;
        this.returnedOn = returnedOn;
        this.status = status;
        this.lateFee = lateFee;
    }

    // Bir abone oyun kiraladığında çağrılacak factory method.
    // Kiralama işlemi için gerekli olan tüm bilgileri alır ve yeni bir Rental
    // nesnesi oluşturur.
    public static Rental open(GameId gameId, MemberId memberId, LocalDate rentedOn, int rentalDays) {

        if (rentalDays < 1) {
            throw new IllegalArgumentException("Rental days must be at least 1");
        }

        // Yeni bir kiralama söz konusu olduğundan bunu ifade edeceğimiz yeni bir
        // benzersiz id gerekiyor.
        RentalId id = RentalId.newId();
        // Kiralam süresini hesaplıyoruz.
        LocalDate dueOn = rentedOn.plusDays(rentalDays);
        // İlk kiralamada gecikme ücreti sıfırdır ve iade tarihi henüz null'dır.
        // Bu nedenle, returnedOn ve lateFee alanlarını null ve sıfır olarak
        // başlatıyoruz.
        return new Rental(id, gameId, memberId, rentedOn, dueOn, null, RentalStatus.ACTIVE, Money.zero(TRY));
    }

    // Sistemde zaten var olan bir kiralama nesnesini yeniden oluşturmak için
    // kullanılacak factory metodumuz.
    public static Rental reconstitute(RentalId id, GameId gameId, MemberId memberId, LocalDate rentedOn,
            LocalDate dueOn, LocalDate returnedOn, RentalStatus status, Money lateFee) {
        return new Rental(id, gameId, memberId, rentedOn, dueOn, returnedOn, status, lateFee);
    }

    // Gecikme söz konusu ise gecikme ücretini hesaplayan private metodumuz.
    // Gecikme yoksa sıfır tutarında bir Money nesnesi döndürür.
    private Money CalculateLateFee(LocalDate returnedOn) {
        if (!returnedOn.isAfter(dueOn)) {
            return Money.zero(TRY);
        }
        long daysLate = java.time.temporal.ChronoUnit.DAYS.between(dueOn, returnedOn);
        return DAILY_LATE_FEE.times(daysLate);
    }

    // Kiralama iade edildiğinde çağrılacak metot.
    // Eğer kiralama zaten iade edilmişse, RentalAlreadyReturnedException fırlatılır
    // Eğer iade tarihi kiralama tarihinden önce ise IllegalArgumentException
    // fırlatılır.
    // Mutlaka bir gecikme ücreti hesaplanır. Zaten gecikme yoksa gecikme ücreti
    // sıfır olacaktır.
    public void returnOn(LocalDate returnedOn) {
        if (status == RentalStatus.RETURNED) {
            throw new RentalAlreadyReturnedException(id);
        }
        if (returnedOn.isBefore(rentedOn)) {
            throw new IllegalArgumentException("Returned date cannot be before rented date");
        }
        this.returnedOn = returnedOn;
        this.lateFee = CalculateLateFee(returnedOn);
        this.status = RentalStatus.RETURNED;
    }

    // Getter metodları
    public RentalId getId() {
        return id;
    }

    public GameId getGameId() {
        return gameId;
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public LocalDate getRentedOn() {
        return rentedOn;
    }

    public LocalDate getDueOn() {
        return dueOn;
    }

    public LocalDate getReturnedOn() {
        return returnedOn;
    }

    public Money getLateFee() {
        return lateFee;
    }

    public RentalStatus getStatus() {
        return status;
    }
}
