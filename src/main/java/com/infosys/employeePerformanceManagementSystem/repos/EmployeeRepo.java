package com.infosys.employeePerformanceManagementSystem.repos;

import com.infosys.employeePerformanceManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
