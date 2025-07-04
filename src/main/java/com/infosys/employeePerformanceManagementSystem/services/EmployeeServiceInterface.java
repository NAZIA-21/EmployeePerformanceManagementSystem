package com.infosys.employeePerformanceManagementSystem.services;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeServiceInterface {

    void addEmployee(String name, double salary, int rating, int departmentId);

    void assignProjectsToEmployee(int empId, List<Integer> projectIds);

}
