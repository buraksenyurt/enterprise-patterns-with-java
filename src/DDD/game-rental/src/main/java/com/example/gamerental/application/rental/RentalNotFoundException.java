package com.example.gamerental.application.rental;

import com.example.gamerental.domain.rental.RentalId;

public class RentalNotFoundException extends RuntimeException {
    public RentalNotFoundException(RentalId rentalId) {
        super("Rental not found with ID: " + rentalId);
    }
}
