package com.example.gamerental.application.game;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gamerental.domain.game.Game;
import com.example.gamerental.domain.game.GameId;
import com.example.gamerental.domain.game.GameRepository;

// GameCatalogService sisteme bir Spring Bean olarak kaydedilir(register) 
// ve bu sayede diğer Spring Bean'ler tarafından kullanılabilir hale gelir.
// C# açısından düşünürsek services.AddScoped ve constructor injection ile aynı mantıkta çalışır.
@Service
public class GameCatalogService {
    private final GameRepository gameRepository;

    public GameCatalogService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Transactional anotasyonu ile işaretlenmiş metodlar, bir transaction içerisinde çalıştırılır. 
    // Eğer metod içerisinde bir exception fırlatılırsa, transaction rollback edilir 
    // ve yapılan değişiklikler geri alınır.
    @Transactional
    public GameId registerGame(RegisterGameCommand command) {
        var game = Game.register(command.title(), command.platform(), command.totalCopies());
        gameRepository.save(game);
        return game.getId();
    }

    // Sadece okuma amaçlı haller için Transaction anotasyonu readOnly = true olarak işaretlenebilir.
    // Zira okuma amaçlı transactionlar, yazma amaçlı transactionlara göre daha performanslıdır.
    @Transactional(readOnly = true)
    public List<Game> listGames() {
        return gameRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Game getGame(GameId gameId) {
        return gameRepository.findById(gameId)
                .orElseThrow(() -> new GameNotFoundException(gameId));
    }
}
