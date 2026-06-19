package com.example.gamerental.infrastructure.game;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.gamerental.domain.game.Game;
import com.example.gamerental.domain.game.GameRepository;

// GameRepository arayüz implementasyonunu yapan adapter sınıfı.
// Save, findById ve findAll metodlarını implement eder.
// Dikkat edileceği üzere GameJpaRepository nesnesi constructor üzerinden enjekte edilir. 
// Bu sayede Spring'in Dependency Injection mekanizmasından yararlanılarak,
// GameJpaRepository'nin bir nesne örneğini içeride kullanabiliriz.
@Repository
public class GameRepositoryAdapter implements GameRepository {
    private final GameJpaRepository gameJpaRepository;

    public GameRepositoryAdapter(GameJpaRepository gameJpaRepository) {
        this.gameJpaRepository = gameJpaRepository;
    }

    @Override
    public void save(com.example.gamerental.domain.game.Game game) {
        var entity = GameMapper.toJpa(game);
        gameJpaRepository.save(entity);
    }

    @Override
    public Optional<Game> findById(
            com.example.gamerental.domain.game.GameId id) {
        return gameJpaRepository.findById(id.value())
                .map(GameMapper::toDomain);
    }

    @Override
    public List<Game> findAll() {
        return gameJpaRepository.findAll().stream()
                .map(GameMapper::toDomain)
                .toList();
    }
}
