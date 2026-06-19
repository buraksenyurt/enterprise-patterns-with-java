package com.example.gamerental.infrastructure.rental;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.gamerental.domain.rental.Rental;
import com.example.gamerental.domain.rental.RentalId;
import com.example.gamerental.domain.rental.RentalRepository;

// Bu ve diğer repository adapter sınıflarımız Infrastructure katmanında yer alıyor 
// ve domain katmanındaki repository arayüzlerini JPA ile entegre ediyor. 
// Yarın bir gün veritabanın değişikliğine gitmek istersek (örneğin MongoDB kullanmak istersek) 
// sadece bu katmanda yeni adapter sınıfları yazmamız yeterli olacaktır. Repository arayüzlerini
// domain katmanına eklememizin bir sebebi de budur.
@Repository
public class RentalRepositoryAdapter implements RentalRepository {

    private final RentalJpaRepository rentalJpaRepository;

    public RentalRepositoryAdapter(RentalJpaRepository rentalJpaRepository) {
        this.rentalJpaRepository = rentalJpaRepository;
    }

    @Override
    public void save(Rental rental) {
        RentalJpaEntity entity = RentalMapper.toJpa(rental);
        rentalJpaRepository.save(entity);
    }

    @Override
    public Optional<Rental> findById(RentalId rentalId) {
        return rentalJpaRepository.findById(rentalId.value())
                .map(RentalMapper::toDomain);
    }
}
