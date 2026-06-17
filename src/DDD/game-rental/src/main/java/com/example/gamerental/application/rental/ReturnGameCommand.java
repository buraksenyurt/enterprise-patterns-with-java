package com.example.gamerental.application.rental;

import java.time.LocalDate;

import com.example.gamerental.domain.rental.RentalId;

public record ReturnGameCommand(RentalId rentalId, LocalDate returnDate) {

}
