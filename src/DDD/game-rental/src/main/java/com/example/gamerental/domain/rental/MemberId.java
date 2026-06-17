package com.example.gamerental.domain.rental;

import java.util.Objects;
import java.util.UUID;

// Gerçek hayat senaryosunda tabii ki Member kavramı kendi bağlamı içerisinde ele alınır
// Bizim senaryomuz girizgah niteliğinde olduğu için sadece ihtiyacımız olan MemberId'yi tanımlıyoruz.
public record MemberId(UUID value) {
    public MemberId {
        Objects.requireNonNull(value, "MemberId cannot be null");
    }

    public static MemberId newId() {
        return new MemberId(UUID.randomUUID());
    }

    public static MemberId of(String value) {
        return new MemberId(UUID.fromString(value));
    }
}
