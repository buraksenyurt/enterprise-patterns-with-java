package com.example.gamerental.application.rental;

import java.time.Clock;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gamerental.application.game.GameNotFoundException;
import com.example.gamerental.domain.game.GameRepository;
import com.example.gamerental.domain.rental.Rental;
import com.example.gamerental.domain.rental.RentalId;
import com.example.gamerental.domain.rental.RentalRepository;

// Bu seferki servis sınıfı iki aggregate root nesnesi ile çalışıyor.
// Temel amacı oyun kiralama işini gerçekleştirmek. 
// Bu yüzden hem GameRepository hem de RentalRepository nesnelerine ihtiyaç duyuyor.

// DİKKAT!
// Bu çalışmada senaryomuz oldukça basit seviyede tutuldu. Normal şartlarda oyun kiralama işi
// gerçekleştiğinde örneğin GameRented isimli bir domain event fırlatılabilir 
// ve bu event'i dinleyen başka bir servis stok güncelleme işini tamamen asenkron olarak gerçekleştirir.
@Service
public class RentGameService {
    private final GameRepository gameRepository;
    private final RentalRepository rentalRepository;
    private final Clock clock;

    public RentGameService(GameRepository gameRepository, RentalRepository rentalRepository, Clock clock) {
        this.gameRepository = gameRepository;
        this.rentalRepository = rentalRepository;
        this.clock = clock;
    }

    // Transactional anotasyonu ile işaretlenmiş metodlar, bir transaction
    // içerisinde çalıştırılır.
    // Bu metot içerisinde öncelikle kiralanmak istenen oyun bulunur. Eğer oyun
    // bulunamazsa GameNotFoundException fırlatılır.
    // Eğer oyun varsa rentOneCopy() metodu çağrılır ve oyun nesnesi güncellenir.
    // Daha sonra yeni bir Rental nesnesi oluşturulur ve kaydedilir.

    @Transactional
    public RentalId rentGame(RentalGameCommand command) {
        var game = gameRepository.findById(command.gameId())
                .orElseThrow(() -> new GameNotFoundException(command.gameId()));

        game.rentOneCopy();

        Rental rental = Rental.open(command.gameId(), command.memberId(), LocalDate.now(clock), command.rentalDays());
        gameRepository.save(game);
        rentalRepository.save(rental);
        return rental.getId();
    }
}
