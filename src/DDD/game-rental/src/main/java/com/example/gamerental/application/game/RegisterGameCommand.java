package com.example.gamerental.application.game;

import com.example.gamerental.domain.game.Platform;

// Bu hafifsiklet immutable komut nesnesi aslında oyun kaydetme niyetimizi temsil eder.
public record RegisterGameCommand(String title, Platform platform, int totalCopies) {

}
