package com.example.gamerental.domain.rental;

import java.util.Objects;
import java.util.UUID;

public record RentalId(UUID value) {
    public RentalId {
        Objects.requireNonNull(value, "RentalId cannot be null");
    }

    public static RentalId newId() {
        return new RentalId(UUID.randomUUID());
    }

    public static RentalId of(String value) {
        return new RentalId(UUID.fromString(value));
    }
}
