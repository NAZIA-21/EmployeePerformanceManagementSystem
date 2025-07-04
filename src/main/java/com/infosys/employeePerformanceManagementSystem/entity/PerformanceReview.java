package com.infosys.employeePerformanceManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class PerformanceReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Rating cannot be null")
    private int rating;

    private LocalDate reviewDate;

    @NotBlank(message = "Remarks cannot be blank")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}

