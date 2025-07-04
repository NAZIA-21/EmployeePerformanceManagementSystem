package com.infosys.employeePerformanceManagementSystem.services;

import com.infosys.employeePerformanceManagementSystem.entity.Department;
import com.infosys.employeePerformanceManagementSystem.repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements DepartmentServiceInterface {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public void addDepartment(String name) {
        Department dept = new Department();
        dept.setDeptName(name);
        departmentRepo.save(dept);
        System.out.println("Department added.");
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }
}
