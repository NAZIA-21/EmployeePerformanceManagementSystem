package com.infosys.employeePerformanceManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @NotBlank(message = "Employee name must not be blank")
    private String empName;

    @NotNull(message = "salary cannot be null")
    private double empSalary;

    @NotNull(message = "ratting must not be null")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects = new ArrayList<>();

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", rating=" + rating +
                ", department=" + department +
                ", projects=" + projects +
                '}';
    }
}

