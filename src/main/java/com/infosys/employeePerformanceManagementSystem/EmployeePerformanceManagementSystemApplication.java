package com.infosys.employeePerformanceManagementSystem;

import com.infosys.employeePerformanceManagementSystem.entity.Department;
import com.infosys.employeePerformanceManagementSystem.entity.PerformanceReview;
import com.infosys.employeePerformanceManagementSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EmployeePerformanceManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private EmployeeBonusService employeeBonusService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private PerformanceReviewService performanceReviewService;

	@Autowired
	private ProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeePerformanceManagementSystemApplication.class, args);
	}

	private final Scanner scanner = new Scanner(System.in);


	@Override
	public void run(String... args) {
		int choice;
		while(true) {
			System.out.println("===== EMPLOYEE PERFORMANCE SYSTEM =====");
			System.out.println("1. Add Department");
			System.out.println("2. Add Employee");
			System.out.println("3. Add Project");
			System.out.println("4. Assign Projects");
			System.out.println("5. Add Performance Review");
			System.out.println("6. Calculate Bonus");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1 -> {
					System.out.print("Enter department name: ");
					String deptName = scanner.nextLine();
					departmentService.addDepartment(deptName);
				}
				case 2 -> {
					List<Department> departments = departmentService.getAllDepartments();
					if (departments.isEmpty()) {
						System.out.println("No departments available. Please add a department first.");
						break;
					}

					System.out.println("Available Departments:");
					for (Department d : departments) {
						System.out.println(d.getDeptId() + ". " + d.getDeptName());
					}

					System.out.print("Enter department ID to assign employee: ");
					int deptId = scanner.nextInt();
					scanner.nextLine();

					System.out.print("Enter employee name: ");
					String empName = scanner.nextLine();

					System.out.print("Enter employee salary: ");
					double salary = scanner.nextDouble();

					System.out.print("Enter employee rating (1–5): ");
					int rating = scanner.nextInt();

					employeeService.addEmployee(empName, salary, rating, deptId);
				}

				case 3 -> {
					System.out.print("Enter project title: ");
					String title = scanner.nextLine();

					System.out.print("Enter duration (in months): ");
					int duration = scanner.nextInt(); scanner.nextLine();

					projectService.addProject(title, duration);
				}

				case 4 -> {
					System.out.print("Enter Employee ID: ");
					int empId = scanner.nextInt();
					scanner.nextLine();

					System.out.print("Enter Project IDs to assign (comma-separated): ");
					String[] parts = scanner.nextLine().split(",");
					List<Integer> projectIds = new ArrayList<>();
					for (String part : parts) {
						projectIds.add(Integer.parseInt(part.trim()));
					}

					employeeService.assignProjectsToEmployee(empId, projectIds);
					System.out.println("Assignment success");
				}

				case 5 -> {
					System.out.println("1. Add Review");
					System.out.println("2. List Reviews");
					int subChoice = scanner.nextInt(); scanner.nextLine();

					if (subChoice == 1) {
						System.out.print("Enter Employee ID: ");
						int empId = scanner.nextInt(); scanner.nextLine();

						System.out.print("Enter Rating (1–5): ");
						int rating = scanner.nextInt(); scanner.nextLine();

						System.out.print("Enter Remarks: ");
						String remarks = scanner.nextLine();

						System.out.print("Enter Date (yyyy-MM-dd): ");
						String dateStr = scanner.nextLine();
						LocalDate date = LocalDate.parse(dateStr);

						performanceReviewService.addReview(empId, rating, remarks, date);
						System.out.println("Review added");
					} else if (subChoice == 2) {
						System.out.print("Enter Employee ID to list reviews: ");
						int empId = scanner.nextInt(); scanner.nextLine();

						List<PerformanceReview> reviews = performanceReviewService.getReviewsByEmployee(empId);
						for (PerformanceReview r : reviews) {
							System.out.println("Date: " + r.getReviewDate() + ", Rating: " + r.getRating() + ", Remarks: " + r.getRemarks());
						}
					}
				}


				case 6 -> {
					System.out.print("Enter employee type [standard/executive]: ");
					String type = scanner.nextLine().trim();

					System.out.print("Enter employee rating: ");
					int rating = scanner.nextInt();

					double bonus = employeeBonusService.computeBonus(type, rating);
					System.out.println("Calculated bonus = Rs. " + bonus);
				}

				case 7 -> System.out.println("Exiting system...");

				default -> System.out.println("Invalid choice. Try again.");
			}
		}
	}


}
