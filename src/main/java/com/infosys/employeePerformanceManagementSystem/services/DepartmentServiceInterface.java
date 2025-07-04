package com.infosys.employeePerformanceManagementSystem.services;

import com.infosys.employeePerformanceManagementSystem.entity.Department;

import java.util.List;

public interface DepartmentServiceInterface {

    void addDepartment(String name);

    List<Department> getAllDepartments();
}
