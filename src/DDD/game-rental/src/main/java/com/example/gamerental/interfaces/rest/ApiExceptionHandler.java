package com.example.gamerental.interfaces.rest;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.gamerental.application.game.GameNotFoundException;
import com.example.gamerental.application.rental.RentalNotFoundException;
import com.example.gamerental.domain.game.NoCopyAvailableException;
import com.example.gamerental.domain.rental.RentalAlreadyReturnedException;

// API Controller tarafındaki statü kodlarını ve hata mesajlarını merkezi olarak yönetmek için 
// kullandığımız basit bir Exception Handler sınıfı.

@RestControllerAdvice
public class ApiExceptionHandler {

    // Not Found durumları için 404 döndürür
    @ExceptionHandler({ GameNotFoundException.class, RentalNotFoundException.class })
    public ResponseEntity<Map<String, String>> notFound(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
    }

    // Bad Request durumları için 400 döndürür
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> badRequest(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
    }

    // Validation hataları için 400 döndürür
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validation(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .findFirst()
                .map(e -> e.getDefaultMessage())
                .orElse("Validation error");
        return ResponseEntity.badRequest().body(Map.of("error", errorMessage));
    }

    // Burada da bazı business logic hataları için 409 Conflict döndürüyoruz.
    // Mesela bir oyunun kiralanacak kopyası kalmamışsa veya zaten iade edilmiş bir
    // kiralama tekrar iade edilmeye çalışılıyorsa.
    @ExceptionHandler({ NoCopyAvailableException.class, RentalAlreadyReturnedException.class })
    public ResponseEntity<Map<String, String>> conflict(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", ex.getMessage()));
    }
}
