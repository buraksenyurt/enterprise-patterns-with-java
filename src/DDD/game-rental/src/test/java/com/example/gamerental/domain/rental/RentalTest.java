package com.example.gamerental.domain.rental;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.example.gamerental.domain.game.GameId;

public class RentalTest {
    private Rental newRental(LocalDate rentedOn, int days) {
        return Rental.open(new GameId(UUID.randomUUID()),
                MemberId.of(UUID.randomUUID().toString()), rentedOn, days);
    }

    @Test
    void cannot_return_twice() {
        Rental rental = newRental(LocalDate.now(), 5);
        rental.returnOn(LocalDate.now().plusDays(3));
        assertThrows(RentalAlreadyReturnedException.class, () -> rental.returnOn(LocalDate.now().plusDays(4)));
    }

    @Test
    void late_return_charges_per_day() {
        Rental rental = newRental(LocalDate.now(), 5);
        rental.returnOn(LocalDate.now().plusDays(7));
        assertEquals("5.00", rental.getLateFee().amount().toPlainString());
    }

    @Test
    void on_time_return_has_no_late_fee() {
        Rental r = newRental(LocalDate.now(), 5);
        r.returnOn(LocalDate.now().plusDays(5));
        assertFalse(r.getLateFee().isPositive());
        assertEquals(RentalStatus.RETURNED, r.getStatus());
    }

    @Test
    void rental_days_must_be_at_least_one() {
        assertThrows(IllegalArgumentException.class, () -> newRental(LocalDate.now(), 0));
        assertThrows(IllegalArgumentException.class, () -> newRental(LocalDate.now(), -1));
    }

    @Test
    void cannot_return_before_rental_date() {
        Rental rental = newRental(LocalDate.now(), 5);
        assertThrows(IllegalArgumentException.class, () -> rental.returnOn(LocalDate.now().minusDays(1)));
    }

    @Test
    void early_return_has_no_late_fee() {
        LocalDate rentalDate = LocalDate.now();
        Rental rental = newRental(rentalDate, 5);
        rental.returnOn(rentalDate.plusDays(2));
        assertFalse(rental.getLateFee().isPositive());
        assertEquals(RentalStatus.RETURNED, rental.getStatus());
    }

    @Test
    void return_on_exact_due_date_has_no_late_fee() {
        LocalDate rentalDate = LocalDate.now();
        Rental rental = newRental(rentalDate, 5);
        rental.returnOn(rentalDate.plusDays(5));
        assertFalse(rental.getLateFee().isPositive());
        assertEquals(RentalStatus.RETURNED, rental.getStatus());
    }

    @Test
    void multiple_days_late_charges_correctly() {
        Rental rental = newRental(LocalDate.now(), 3);
        rental.returnOn(LocalDate.now().plusDays(8)); // 5 days late
        assertEquals("12.50", rental.getLateFee().amount().toPlainString());
    }

    @Test
    void returned_rental_has_returned_on_date() {
        LocalDate rentalDate = LocalDate.now();
        LocalDate returnDate = rentalDate.plusDays(4);
        Rental rental = newRental(rentalDate, 5);
        rental.returnOn(returnDate);
        assertEquals(returnDate, rental.getReturnedOn());
    }

    @Test
    void new_rental_has_active_status() {
        Rental rental = newRental(LocalDate.now(), 5);
        assertEquals(RentalStatus.ACTIVE, rental.getStatus());
    }

    @Test
    void new_rental_has_zero_late_fee() {
        Rental rental = newRental(LocalDate.now(), 5);
        assertFalse(rental.getLateFee().isPositive());
    }

    @Test
    void new_rental_has_no_returned_on_date() {
        Rental rental = newRental(LocalDate.now(), 5);
        assertEquals(null, rental.getReturnedOn());
    }

    @Test
    void getters_return_correct_values() {
        LocalDate rentalDate = LocalDate.now();
        GameId gameId = new GameId(UUID.randomUUID());
        MemberId memberId = MemberId.of(UUID.randomUUID().toString());
        Rental rental = Rental.open(gameId, memberId, rentalDate, 5);
        
        assertEquals(gameId, rental.getGameId());
        assertEquals(memberId, rental.getMemberId());
        assertEquals(rentalDate, rental.getRentedOn());
        assertEquals(rentalDate.plusDays(5), rental.getDueOn());
    }
}
