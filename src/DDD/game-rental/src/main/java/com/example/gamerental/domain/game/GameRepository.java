package com.example.gamerental.domain.game;

import java.util.List;
import java.util.Optional;

/*
    Domain'in neye ihtiyacı olduğunu arayüzler (interface) ile tanımlayabiliriz.
    Asıl implmentasyon yani veri tabanı ile entegrasyon gibi detaylar ise bu arayüzü
    implemente eden ve infrastructure katmanında yer alan sınıflarda yapılır.

    Tipik bir Dependency Inversion Principle (DIP) uygulaması. 
    Domain katmanı, veri depolama detaylarından bağımsız.

    GameRepository arayüzü, oyun nesnelerini depolamak ve erişmek için gerekli olan operasyonları tanımlar.
    Bu sayede, domain katmanımız veri depolama detaylarından bağımsız hale gelir, 
    daha esnek bir mimari oluşturmuş olur.

    Üç basit davranış tanımladık:
    1. save(Game game): Bir oyun nesnesini depolar veya günceller.
    2. findById(GameId id): Belirli bir ID'ye sahip bir oyun nesnesini bulur ve döndürür. 
    Eğer böyle bir oyun yoksa, Optional.empty() döner.
    3. findAll(): Tüm oyun nesnelerini bir liste olarak döndürür.
*/
public interface GameRepository {
    void save(Game game);

    Optional<Game> findById(GameId id);

    List<Game> findAll();
}
