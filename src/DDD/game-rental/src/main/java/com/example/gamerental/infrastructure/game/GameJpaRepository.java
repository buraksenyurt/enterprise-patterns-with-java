package com.example.gamerental.infrastructure.game;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data implementasyonu çalışma zamanında(runtime) yapar.
// Domain sadece GameRepository arayüzünü görür, Spring Data'nın JpaRepository'sini görmez.
// Peki ne üretir? GameJpaRepository arayüzü için bir implementasyon sınıfı üretir ve bu sınıf, 
// GameJpaEntity'leri yönetmek için gerekli CRUD operasyonlarını sağlar.
public interface GameJpaRepository extends JpaRepository<GameJpaEntity, UUID> {
    
}
