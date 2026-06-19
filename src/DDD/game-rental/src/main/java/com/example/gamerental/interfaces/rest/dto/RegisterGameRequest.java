package com.example.gamerental.interfaces.rest.dto;

import com.example.gamerental.domain.game.Platform;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// API sözleşmesi (contract) iç modele herhangi bir şekilde sızmamalı ve istemci talepleri
// ile ilgili doğrulamalar da bu tarafta olmalıdır. DTO (Data Transfer Object) nesnesini bu amaçla
// kullanıyoruz.
// Title boş olamaz, platform null olamaz, toplam kopya sayısı 1'den az olamaz 
// gibi doğrulamaları burada yapıyoruz.
public record RegisterGameRequest(
        @NotBlank String title,
        @NotNull Platform platform,
        @Min(1) int totalCopies) {
}
