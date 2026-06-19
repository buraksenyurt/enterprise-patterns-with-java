package com.example.gamerental.interfaces.rest.dto;

import com.example.gamerental.domain.game.Game;

public record GameResponse(
        String id,
        String title,
        String platform,
        int totalCopies,
        int availableCopies) {

    public static GameResponse from(Game game) {
        return new GameResponse(
                game.getId().value().toString(),
                game.getTitle(),
                game.getPlatform().name(),
                game.getTotalCopies(),
                game.getAvailableCopies());
    }
}
