package com.infosys.employeePerformanceManagementSystem.services;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

@Component
@Primary
@Qualifier("executiveBonus")
public class ExecutiveBonusService implements BonusService {

    private final Map<Integer, Double> bonusMap = Map.of(
            5, 10000.0,
            4, 8000.0,
            3, 6000.0,
            2, 4000.0,
            1, 0.0
    );

    @Override
    public double calculateBonus(int rating) {
        return bonusMap.getOrDefault(rating, 0.0);
    }
}

