package com.example.gamerental.infrastructure.rental;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalJpaRepository extends JpaRepository<RentalJpaEntity, UUID> {
    
}
