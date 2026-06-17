package com.example.gamerental.application.rental;

import com.example.gamerental.domain.game.GameId;
import com.example.gamerental.domain.rental.MemberId;

public record RentalGameCommand(GameId gameId, MemberId memberId, int rentalDays) {

}
