package com.infosys.employeePerformanceManagementSystem.services;

import com.infosys.employeePerformanceManagementSystem.entity.Project;
import com.infosys.employeePerformanceManagementSystem.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements ProjectServiceInterface{

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public void addProject(String title, int durationMonths) {
        Project project = new Project();
        project.setTitle(title);
        project.setDurationMonths(durationMonths);
        projectRepo.save(project);
        System.out.println("Project added.");
    }

}
