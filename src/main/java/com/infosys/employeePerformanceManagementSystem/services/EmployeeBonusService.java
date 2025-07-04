package com.infosys.employeePerformanceManagementSystem.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeBonusService {

    private final BonusService standardBonusService;
    private final BonusService executiveBonusService;

    public EmployeeBonusService(
            @Qualifier("standardBonus") BonusService standardBonusService,
            @Qualifier("executiveBonus") BonusService executiveBonusService) {
        this.standardBonusService = standardBonusService;
        this.executiveBonusService = executiveBonusService;
    }

    public double computeBonus(String type, int rating) {
        if ("executive".equalsIgnoreCase(type)) {
            return executiveBonusService.calculateBonus(rating);
        } else {
            return standardBonusService.calculateBonus(rating);
        }
    }
}

