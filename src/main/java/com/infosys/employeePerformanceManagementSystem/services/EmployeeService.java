package com.infosys.employeePerformanceManagementSystem.services;

import com.infosys.employeePerformanceManagementSystem.entity.Department;
import com.infosys.employeePerformanceManagementSystem.entity.Employee;
import com.infosys.employeePerformanceManagementSystem.entity.Project;
import com.infosys.employeePerformanceManagementSystem.repos.DepartmentRepo;
import com.infosys.employeePerformanceManagementSystem.repos.EmployeeRepo;
import com.infosys.employeePerformanceManagementSystem.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface{
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public void addEmployee(String name, double salary, int rating, int departmentId) {
        Department dept = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + departmentId));

        Employee emp = new Employee();
        emp.setEmpName(name);
        emp.setEmpSalary(salary);
        emp.setRating(rating);
        emp.setDepartment(dept);

        employeeRepo.save(emp);
        System.out.println("Employee added and assigned to department.");
    }

    @Override
    @Transactional
    public void assignProjectsToEmployee(int empId, List<Integer> projectIds) {
        Employee emp = employeeRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        List<Project> projects = projectRepo.findAllById(projectIds);
        emp.getProjects().addAll(projects);
        employeeRepo.save(emp);
    }

}
