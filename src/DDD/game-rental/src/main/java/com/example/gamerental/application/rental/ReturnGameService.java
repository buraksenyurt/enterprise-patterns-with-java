package com.example.gamerental.application.rental;

import org.springframework.stereotype.Service;

import com.example.gamerental.application.game.GameNotFoundException;
import com.example.gamerental.domain.game.GameRepository;
import com.example.gamerental.domain.rental.RentalRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReturnGameService {
    private final GameRepository gameRepository;
    private final RentalRepository rentalRepository;

    public ReturnGameService(GameRepository gameRepository, RentalRepository rentalRepository) {
        this.gameRepository = gameRepository;
        this.rentalRepository = rentalRepository;
    }

    @Transactional
    public void returnGame(ReturnGameCommand command) {
        var rental = rentalRepository.findById(command.rentalId())
                .orElseThrow(() -> new RentalNotFoundException(command.rentalId()));

        var game = gameRepository.findById(rental.getGameId())
                .orElseThrow(() -> new GameNotFoundException(rental.getGameId()));

        rental.returnOn(command.returnDate());
        game.returnOneCopy();
        rentalRepository.save(rental);
        gameRepository.save(game);
    }
}
