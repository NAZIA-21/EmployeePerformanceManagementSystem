package com.infosys.employeePerformanceManagementSystem.services;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

@Component
@Qualifier("standardBonus")
public class StandardBonusService implements BonusService {

    private final Map<Integer, Double> bonusMap = Map.of(
            5, 5000.0,
            4, 4000.0,
            3, 3000.0,
            2, 2000.0,
            1, 0.0
    );

    @Override
    public double calculateBonus(int rating) {
        return bonusMap.getOrDefault(rating, 0.0);
    }
}

