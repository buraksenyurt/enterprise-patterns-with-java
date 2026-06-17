package com.example.gamerental.domain.shared;

/* 
    Domain içerisindeki iş kurallarının ihlal edildiği durumlarda ortama 
    fırlatılacak örnek RuntimeException türevi.
 */
public abstract class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}