package com.example.gamerental.interfaces.rest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RentGameRequest(
    @NotNull String gameId, 
    @NotNull String memberId, 
    @Min(1) int rentalDays) {
}
