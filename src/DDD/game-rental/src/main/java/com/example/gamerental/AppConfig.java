package com.example.gamerental;

import java.time.Clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// AppConfig sınıfı Spring Boot uygulamasının konfigürasyon sınıfıdır.
// Bu sınıf içerisinde uygulamanın ihtiyaç duyduğu bean'ler tanımlanır.
//
// Örneğin Clock bean'i, uygulamanın saat ve tarih işlemlerinde kullanılacak
// bir bean olarak tanımlanmıştır. Bu sayede uygulamanın farklı yerlerinde 
// saat ve tarih işlemleri için Clock bean'i kullanabiliriz. 
// RentGameService sınıfında Clock bean'i constructor üzerinden enjekte ediliyor.

@Configuration
public class AppConfig {
    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
