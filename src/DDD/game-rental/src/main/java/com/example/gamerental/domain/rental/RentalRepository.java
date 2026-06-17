package com.example.gamerental.domain.rental;

import java.util.Optional;

public interface RentalRepository {
    void save(Rental rental);

    Optional<Rental> findById(RentalId id);
}
