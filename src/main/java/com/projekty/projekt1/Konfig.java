package com.projekty.projekt1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Konfig {
    @Bean
    CommandLineRunner commandLineRunner(Repozytorium studentRepozytorium,PrzedmiotRepo przedmiotRepozytorium) {
        return args -> {
            // Celowo pozostawione puste.
            // Dane zostały już dodane do bazy przy pierwszym uruchomieniu.
        };
    }
}