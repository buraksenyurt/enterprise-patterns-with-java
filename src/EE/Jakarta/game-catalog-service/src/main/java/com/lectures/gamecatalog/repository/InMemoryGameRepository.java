package com.lectures.gamecatalog.repository;

import com.lectures.gamecatalog.model.Game;
import com.lectures.gamecatalog.model.Genre;
import com.lectures.gamecatalog.model.Platform;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class InMemoryGameRepository implements GameRepository {

    @Override
    public Game save(Game game) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<Game> update(Long id, Game game) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<Game> findById(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Game> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Game> findByGenre(Genre genre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Game> findByPlatform(Platform platform) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
