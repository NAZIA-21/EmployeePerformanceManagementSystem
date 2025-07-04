package com.infosys.employeePerformanceManagementSystem.services;

import com.infosys.employeePerformanceManagementSystem.entity.PerformanceReview;

import java.time.LocalDate;
import java.util.List;

public interface PerformanceReviewServiceInterface {

    void addReview(int empId, int rating, String remarks, LocalDate date);

    List<PerformanceReview> getReviewsByEmployee(int empId);
}
