package com.example.gamerental.domain.game;

import java.util.Objects;
import java.util.UUID;

// Oyunları benzersiz şekilde tanımlamak için kullanacağımız UUID bilgisini
// bir record türüne sarmalıyoruz(Wrap). 
// Böylece GameId'ler de immutable olur ve sadece UUID'nin kendisiyle ilgilenebiliriz.
public record GameId(UUID value) {
    // Compact Constructor
    // Henüz nesne oluşturulurken null kontrolü yapıyoruz.
    public GameId {
        Objects.requireNonNull(value, "GameId cannot be null");
    }

    // Yeni bir GameId oluşturmak için yardımcı metod
    // UUID.randomUUID() ile benzersiz bir UUID oluşturuyoruz.
    public static GameId newId() {
        return new GameId(UUID.randomUUID());
    }

    // Burada ise String veriden GameId oluşturuyoruz.
    // Pek tabii geçersiz bir UUID string'i gelirse IllegalArgumentException
    // fırlatılacaktır.
    public static GameId of(String value) {
        return new GameId(UUID.fromString(value));
    }
}