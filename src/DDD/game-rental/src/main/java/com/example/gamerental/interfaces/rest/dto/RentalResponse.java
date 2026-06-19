package com.example.gamerental.interfaces.rest.dto;

import com.example.gamerental.domain.rental.Rental;

public record RentalResponse(
        String rentalId,
        String gameId,
        String memberId,
        String rentedOn,
        String dueOn,
        String returnedOn,
        String status,
        String lateFeeAmount,
        String lateFeeCurrency) {

    public static RentalResponse from(Rental rental) {
        return new RentalResponse(
                rental.getId().value().toString(),
                rental.getGameId().value().toString(),
                rental.getMemberId().value().toString(),
                rental.getRentedOn().toString(),
                rental.getDueOn().toString(),
                rental.getReturnedOn() != null ? rental.getReturnedOn().toString() : null,
                rental.getStatus().name(),
                rental.getLateFee().amount().toPlainString(),
                rental.getLateFee().currency().getCurrencyCode());
    }
}
