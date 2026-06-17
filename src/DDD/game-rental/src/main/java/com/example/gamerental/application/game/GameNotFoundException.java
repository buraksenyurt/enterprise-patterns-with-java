package com.example.gamerental.application.game;

import com.example.gamerental.domain.game.GameId;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(GameId gameId) {
        super("Game not found with ID: " + gameId);
    }
}
