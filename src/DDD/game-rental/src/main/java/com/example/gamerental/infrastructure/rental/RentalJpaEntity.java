package com.example.gamerental.infrastructure.rental;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.example.gamerental.domain.rental.RentalStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rentals")
public class RentalJpaEntity {
    @Id
    private UUID id;
    private UUID gameId;
    private UUID memberId;
    private LocalDate rentedOn;
    private LocalDate dueOn;
    private LocalDate returnedOn;

    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    private BigDecimal lateFeeAmount;
    private String lateFeeCurrency;

    protected RentalJpaEntity() {
    }

    //todo@buraksenyurt Çok fazla parametre alıyor belki bir builder ile ilerlenebilir mi? Ya da alternatif.
    public RentalJpaEntity(UUID id, UUID gameId, UUID memberId, LocalDate rentedOn, LocalDate dueOn,
            LocalDate returnedOn, RentalStatus status, BigDecimal lateFeeAmount, String lateFeeCurrency) {
        this.id = id;
        this.gameId = gameId;
        this.memberId = memberId;
        this.rentedOn = rentedOn;
        this.dueOn = dueOn;
        this.returnedOn = returnedOn;
        this.status = status;
        this.lateFeeAmount = lateFeeAmount;
        this.lateFeeCurrency = lateFeeCurrency;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public UUID getGameId() {
        return gameId;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public LocalDate getRentedOn() {
        return rentedOn;
    }

    public LocalDate getDueOn() {
        return dueOn;
    }

    public LocalDate getReturnedOn() {
        return returnedOn;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public BigDecimal getLateFeeAmount() {
        return lateFeeAmount;
    }

    public String getLateFeeCurrency() {
        return lateFeeCurrency;
    }
}
