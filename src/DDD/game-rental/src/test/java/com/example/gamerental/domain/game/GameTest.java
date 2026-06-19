package com.example.gamerental.domain.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GameTest {
    private Game newGame(String title, Platform platform, int totalCopies) {
        return Game.register(title, platform, totalCopies);
    }

    @Test
    void register_new_game_creates_game_with_available_copies() {
        Game game = newGame("Elden Ring", Platform.PLAYSTATION, 10);
        assertEquals(10, game.getAvailableCopies());
        assertEquals(10, game.getTotalCopies());
        assertEquals("Elden Ring", game.getTitle());
        assertEquals(Platform.PLAYSTATION, game.getPlatform());
    }

    @Test
    void title_cannot_be_null() {
        assertThrows(IllegalArgumentException.class, () -> newGame(null, Platform.PC, 5));
    }

    @Test
    void title_cannot_be_empty() {
        assertThrows(IllegalArgumentException.class, () -> newGame("", Platform.PC, 5));
    }

    @Test
    void title_cannot_be_blank() {
        assertThrows(IllegalArgumentException.class, () -> newGame("   ", Platform.PC, 5));
    }

    @Test
    void total_copies_must_be_at_least_one() {
        assertThrows(IllegalArgumentException.class, () -> newGame("Game Title", Platform.XBOX, 0));
        assertThrows(IllegalArgumentException.class, () -> newGame("Game Title", Platform.XBOX, -1));
    }

    @Test
    void rent_one_copy_decreases_available_copies() {
        Game game = newGame("The Witcher 3", Platform.PC, 5);
        game.rentOneCopy();
        assertEquals(4, game.getAvailableCopies());
    }

    @Test
    void rent_multiple_copies_decreases_correctly() {
        Game game = newGame("Cyberpunk 2077", Platform.XBOX, 8);
        game.rentOneCopy();
        game.rentOneCopy();
        game.rentOneCopy();
        assertEquals(5, game.getAvailableCopies());
    }

    @Test
    void cannot_rent_when_no_copies_available() {
        Game game = newGame("Halo", Platform.XBOX, 1);
        game.rentOneCopy();
        assertThrows(NoCopyAvailableException.class, game::rentOneCopy);
    }

    @Test
    void return_one_copy_increases_available_copies() {
        Game game = newGame("God of War", Platform.PLAYSTATION, 5);
        game.rentOneCopy();
        game.returnOneCopy();
        assertEquals(5, game.getAvailableCopies());
    }

    @Test
    void return_multiple_copies_increases_correctly() {
        Game game = newGame("Final Fantasy XVI", Platform.PLAYSTATION, 6);
        game.rentOneCopy();
        game.rentOneCopy();
        game.returnOneCopy();
        assertEquals(5, game.getAvailableCopies());
    }

    @Test
    void cannot_return_when_all_copies_already_available() {
        Game game = newGame("Starfield", Platform.XBOX, 3);
        assertThrows(IllegalStateException.class, game::returnOneCopy);
    }

    @Test
    void cannot_return_more_copies_than_rented() {
        Game game = newGame("Baldur's Gate 3", Platform.PC, 4);
        game.rentOneCopy();
        game.returnOneCopy();
        assertThrows(IllegalStateException.class, game::returnOneCopy);
    }

    @Test
    void reconstitute_creates_game_with_specific_state() {
        GameId gameId = GameId.newId();
        Game game = Game.reconstitute(gameId, "Skyrim", Platform.NINTENDO_SWITCH, 7, 3);

        assertEquals(gameId, game.getId());
        assertEquals("Skyrim", game.getTitle());
        assertEquals(Platform.NINTENDO_SWITCH, game.getPlatform());
        assertEquals(7, game.getTotalCopies());
        assertEquals(3, game.getAvailableCopies());
    }

    @Test
    void game_id_is_unique_for_new_registrations() {
        Game game1 = newGame("Game 1", Platform.PC, 2);
        Game game2 = newGame("Game 2", Platform.PC, 2);

        assertEquals(false, game1.getId().equals(game2.getId()));
    }

    @Test
    void available_copies_cannot_exceed_total_copies() {
        GameId gameId = GameId.newId();
        assertThrows(IllegalArgumentException.class,
                () -> Game.reconstitute(gameId, "Test Game", Platform.PC, 5, 10));
    }

    @Test
    void available_copies_cannot_be_negative() {
        GameId gameId = GameId.newId();
        assertThrows(IllegalArgumentException.class,
                () -> Game.reconstitute(gameId, "Test Game", Platform.PC, 5, -1));
    }

    @Test
    void rent_and_return_cycle_maintains_consistency() {
        Game game = newGame("Portal 2", Platform.PC, 3);
        int initialCopies = game.getAvailableCopies();

        game.rentOneCopy();
        assertEquals(initialCopies - 1, game.getAvailableCopies());

        game.rentOneCopy();
        assertEquals(initialCopies - 2, game.getAvailableCopies());

        game.returnOneCopy();
        assertEquals(initialCopies - 1, game.getAvailableCopies());

        game.returnOneCopy();
        assertEquals(initialCopies, game.getAvailableCopies());
    }
}
