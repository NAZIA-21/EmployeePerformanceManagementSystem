package com.infosys.employeePerformanceManagementSystem.repos;

import com.infosys.employeePerformanceManagementSystem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
}
