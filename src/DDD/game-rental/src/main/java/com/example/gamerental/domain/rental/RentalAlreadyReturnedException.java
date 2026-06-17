package com.example.gamerental.domain.rental;

import com.example.gamerental.domain.shared.DomainException;

/*
    Bir başka kalkan (Guard) sınıfı olan DomainException sınıfından türettiğimiz 
    bir alt domain exception sınıfı.
    Sistemde iade edilmek istenen kiralama zaten iade edilmişse fırlatılılır.
*/
public class RentalAlreadyReturnedException extends DomainException {
    public RentalAlreadyReturnedException(RentalId rentalId) {
        super("Rental with ID: " + rentalId + " has already been returned.");
    }

}
