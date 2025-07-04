package com.infosys.employeePerformanceManagementSystem.repos;

import com.infosys.employeePerformanceManagementSystem.entity.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceReviewRepo extends JpaRepository<PerformanceReview, Integer> {

    List<PerformanceReview> findByEmployeeEmpId(int employeeId);
}
