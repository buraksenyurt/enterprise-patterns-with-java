package com.example.gamerental.domain.game;

import com.example.gamerental.domain.shared.DomainException;

/*
    DomainException sınıfından türettiğimiz bir alt domain exception sınıfı.
    Sistemde kiralanmak istenen oyunun kopyası mevcut değilse fırlatılabilir.
*/
public class NoCopyAvailableException extends DomainException {
    public NoCopyAvailableException(GameId gameId) {
        super("No copy available for game with ID: " + gameId);
    }

}
