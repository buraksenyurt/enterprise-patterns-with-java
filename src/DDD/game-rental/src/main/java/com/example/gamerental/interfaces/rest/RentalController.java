package com.example.gamerental.interfaces.rest;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.gamerental.application.rental.RentGameService;
import com.example.gamerental.application.rental.RentalGameCommand;
import com.example.gamerental.application.rental.RentalNotFoundException;
import com.example.gamerental.application.rental.ReturnGameCommand;
import com.example.gamerental.application.rental.ReturnGameService;
import com.example.gamerental.domain.game.GameId;
import com.example.gamerental.domain.rental.MemberId;
import com.example.gamerental.domain.rental.RentalId;
import com.example.gamerental.domain.rental.RentalRepository;
import com.example.gamerental.interfaces.rest.dto.RentGameRequest;
import com.example.gamerental.interfaces.rest.dto.RentalResponse;
import com.example.gamerental.interfaces.rest.dto.ReturnGameRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    private final RentGameService rentGameService;
    private final ReturnGameService returnGameService;
    private final RentalRepository rentalRepository;
    private final Clock clock;

    public RentalController(RentGameService rentGameService, ReturnGameService returnGameService,
            RentalRepository rentalRepository, Clock clock) {
        this.rentGameService = rentGameService;
        this.returnGameService = returnGameService;
        this.rentalRepository = rentalRepository;
        this.clock = clock;
    }

    @GetMapping("/{id}")
    public RentalResponse getRental(@PathVariable String id) {
        // Dikkat edileceği üzere kiralama bilgileri bulunamazsa,
        // RentalNotFoundException fırlatıyoruz. Bu exception ApiExceptionHandler
        // tarafından yakalanacak ve 404 Not Found olarak cevap dönülecek.
        return rentalRepository
                .findById(RentalId.of(id))
                .map(RentalResponse::from)
                .orElseThrow(() -> new RentalNotFoundException(RentalId.of(id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> rent(@Valid @RequestBody RentGameRequest req) {
        RentalId id = rentGameService.rentGame(new RentalGameCommand(
                GameId.of(req.gameId()),
                MemberId.of(req.memberId()),
                req.rentalDays()));
        return Map.of("rentalId", id.value().toString());
    }

    @PostMapping("/{id}/return")
    public RentalResponse giveBack(@PathVariable String id, @RequestBody(required = false) ReturnGameRequest req) {
        LocalDate returnDate = (req != null && req.returnDate() != null)
                ? req.returnDate()
                : LocalDate.now(clock);

        RentalId rentalId = RentalId.of(id);
        returnGameService.returnGame(new ReturnGameCommand(rentalId, returnDate));

        return rentalRepository.findById(rentalId)
                .map(RentalResponse::from)
                .orElseThrow(() -> new RentalNotFoundException(rentalId));
    }
}
