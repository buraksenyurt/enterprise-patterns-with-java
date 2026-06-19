package com.example.gamerental.infrastructure.game;

import com.example.gamerental.domain.game.Game;
import com.example.gamerental.domain.game.GameId;

// JPA Entity'leri ile Domain nesneleri arasında dönüşüm yapmak için kullanılan mapper sınıfı.

// final ile işaretlenmiştir zira türetilmemesi istenen bir sınıftır. 
// Mapper sınıfları genellikle statik metodlar içerir ve nesne örneği oluşturulmaz, 
// bu yüzden final olarak işaretlenirler.
final class GameMapper {

    // Statik metotlar ile JPA Entity -> Domain ve Domain -> JPA Entity dönüşümleri yapılır.
    static GameJpaEntity toJpa(Game game) {
        return new GameJpaEntity(
                game.getId().value(),
                game.getTitle(),
                game.getPlatform(),
                game.getTotalCopies(),
                game.getAvailableCopies());
    }

    static Game toDomain(GameJpaEntity entity) {
        return Game.reconstitute(
                new GameId(entity.getId()),
                entity.getTitle(),
                entity.getPlatform(),
                entity.getTotalCopies(),
                entity.getAvailableCopies());
    }

    private GameMapper() {
        // private constructor ile bu sınıftan nesne oluşturulmasının önüne geçilir.
    }
}
