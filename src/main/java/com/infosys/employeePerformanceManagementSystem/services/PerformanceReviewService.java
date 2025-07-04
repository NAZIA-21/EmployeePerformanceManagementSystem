package com.infosys.employeePerformanceManagementSystem.services;

import com.infosys.employeePerformanceManagementSystem.entity.Employee;
import com.infosys.employeePerformanceManagementSystem.entity.PerformanceReview;
import com.infosys.employeePerformanceManagementSystem.repos.EmployeeRepo;
import com.infosys.employeePerformanceManagementSystem.repos.PerformanceReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PerformanceReviewService implements PerformanceReviewServiceInterface{

    @Autowired
    private PerformanceReviewRepo reviewRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void addReview(int empId, int rating, String remarks, LocalDate date) {
        Employee emp = employeeRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        PerformanceReview review = new PerformanceReview();
        review.setRating(rating);
        review.setRemarks(remarks);
        review.setReviewDate(date);
        review.setEmployee(emp);

        reviewRepo.save(review);
    }

    @Override
    public List<PerformanceReview> getReviewsByEmployee(int empId) {
        return reviewRepo.findByEmployeeEmpId(empId);
    }

}
