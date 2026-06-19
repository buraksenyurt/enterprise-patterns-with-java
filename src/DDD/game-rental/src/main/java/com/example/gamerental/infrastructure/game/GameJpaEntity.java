package com.example.gamerental.infrastructure.game;

import java.util.UUID;

import com.example.gamerental.domain.game.Platform;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// JPA (Java Persistence API) nesnemiz. Veritabanındaki "games" tablosuna karşılık gelen sınıf olarak düşünebiliriz.
// ORM aracı olarak kullanılan Hibernate için gerekli anotasyonlar da yer alır. Ayrıca,
// no-args constructor (parametresiz constructor) protected olarak tanımlanır, 
// çünkü JPA tarafında parametresiz constructor gereklidir.
@Entity
@Table(name = "games")
public class GameJpaEntity {
    @Id
    private UUID id;
    private String title;

    @Enumerated(EnumType.STRING)
    private Platform platform;

    private int totalCopies;
    private int availableCopies;

    protected GameJpaEntity() {
    }

    public GameJpaEntity(UUID id, String title, Platform platform, int totalCopies, int availableCopies) {
        this.id = id;
        this.title = title;
        this.platform = platform;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }
}
