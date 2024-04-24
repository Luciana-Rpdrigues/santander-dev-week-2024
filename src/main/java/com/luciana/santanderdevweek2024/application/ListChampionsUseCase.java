package com.luciana.santanderdevweek2024.application;

import com.luciana.santanderdevweek2024.domain.model.Champion;
import com.luciana.santanderdevweek2024.domain.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {
    public List<Champion> findAll() {
        return repository.findAll();
    }
}
