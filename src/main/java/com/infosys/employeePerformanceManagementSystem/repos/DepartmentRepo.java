package com.infosys.employeePerformanceManagementSystem.repos;

import com.infosys.employeePerformanceManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
