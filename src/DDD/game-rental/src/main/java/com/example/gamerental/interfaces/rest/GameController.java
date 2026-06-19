package com.example.gamerental.interfaces.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.gamerental.application.game.GameCatalogService;
import com.example.gamerental.application.game.RegisterGameCommand;
import com.example.gamerental.domain.game.GameId;
import com.example.gamerental.interfaces.rest.dto.GameResponse;
import com.example.gamerental.interfaces.rest.dto.RegisterGameRequest;

import jakarta.validation.Valid;

// Tipik bir REST Controller sınıfı. 
// Sadece Game ile ilgili endpointleri barındırıyoruz.
// Oyun kaydetme, listeleme ve id bazlı oyun bilgisi getirme gibi operasyonlar sağlıyoruz.
@RestController
@RequestMapping("/api/games")
public class GameController {
    private final GameCatalogService gameCatalogService;

    public GameController(GameCatalogService gameCatalogService) {
        this.gameCatalogService = gameCatalogService;
    }

    @GetMapping("/{id}")
    public GameResponse getGame(@PathVariable String id) {
        return GameResponse.from(gameCatalogService.getGame(GameId.of(id)));
    }

    @GetMapping
    public List<GameResponse> list() {
        return gameCatalogService
                .listGames()
                .stream()
                .map(GameResponse::from)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> register(@Valid @RequestBody RegisterGameRequest request) {
        GameId gameId = gameCatalogService.registerGame(
                new RegisterGameCommand(
                        request.title(),
                        request.platform(),
                        request.totalCopies()));
        return Map.of("gameId", gameId.toString());
    }
}
