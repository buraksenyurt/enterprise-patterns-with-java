package com.example.gamerental.infrastructure.rental;

import java.util.Currency;

import com.example.gamerental.domain.game.GameId;
import com.example.gamerental.domain.rental.MemberId;
import com.example.gamerental.domain.rental.Rental;
import com.example.gamerental.domain.rental.RentalId;
import com.example.gamerental.domain.shared.Money;

final class RentalMapper {

    private RentalMapper() {
    }

    static RentalJpaEntity toJpa(Rental rental) {
        return new RentalJpaEntity(
                rental.getId().value(),
                rental.getGameId().value(),
                rental.getMemberId().value(),
                rental.getRentedOn(),
                rental.getDueOn(),
                rental.getReturnedOn(),
                rental.getStatus(),
                rental.getLateFee().amount(),
                rental.getLateFee().currency().getCurrencyCode());
    }

    static Rental toDomain(RentalJpaEntity entity) {
        Money lateFee = new Money(
                entity.getLateFeeAmount(),
                Currency.getInstance(entity.getLateFeeCurrency()));
        return Rental.reconstitute(
                new RentalId(entity.getId()),
                new GameId(entity.getGameId()),
                new MemberId(entity.getMemberId()),
                entity.getRentedOn(),
                entity.getDueOn(),
                entity.getReturnedOn(),
                entity.getStatus(),
                lateFee);
    }
}
