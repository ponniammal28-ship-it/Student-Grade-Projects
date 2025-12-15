package com.grades;

import java.util.Scanner;
import java.util.List;

/**
 * Main application for managing student grades
 * Provides a menu-driven console interface
 */
public class StudentGradeApp {
    private GradeManager gradeManager;
    private Scanner scanner;

    /**
     * Constructor for the application
     */
    public StudentGradeApp() {
        this.gradeManager = new GradeManager();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Start the application
     */
    public void start() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║   Welcome to Student Grade Management System   ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addGradeToStudent();
                    break;
                case 3:
                    viewStudentDetails();
                    break;
                case 4:
                    displaySummaryReport();
                    break;
                case 5:
                    listAllStudents();
                    break;
                case 6:
                    removeStudent();
                    break;
                case 7:
                    System.out.println("\nThank you for using the Student Grade Management System!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
            System.out.println(); 
        }
        scanner.close();
    }

    /**
     * Display the main menu
     */
    private void displayMainMenu() {
        System.out.println("┌─ Main Menu ─────────────────────────────────┐");
        System.out.println("│ 1. Add a new student                        │");
        System.out.println("│ 2. Add a grade to a student                 │");
        System.out.println("│ 3. View student details                     │");
        System.out.println("│ 4. Display summary report                   │");
        System.out.println("│ 5. List all students                        │");
        System.out.println("│ 6. Remove a student                         │");
        System.out.println("│ 7. Exit                                     │");
        System.out.println("└─────────────────────────────────────────────┘");
        System.out.print("Enter your choice (1-7): ");
    }

    /**
     * Add a new student
     */
    private void addNewStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("❌ Name cannot be empty!");
            return;
        }

        System.out.print("Enter student ID: ");
        int id = getIntInput();

        try {
            Student student = new Student(name, id);
            gradeManager.addStudent(student);
            System.out.println("✓ Student '" + name + "' added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    /**
     * Add a grade to a student
     */
    private void addGradeToStudent() {
        System.out.println("\n--- Add Grade to Student ---");
        System.out.print("Enter student ID: ");
        int id = getIntInput();

        Student student = gradeManager.findStudentById(id);
        if (student == null) {
            System.out.println("❌ Student with ID " + id + " not found!");
            return;
        }

        System.out.print("Enter grade (0-100): ");
        double grade = getDoubleInput();

        try {
            student.addGrade(grade);
            System.out.println("✓ Grade added successfully for " + student.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    /**
     * View details of a specific student
     */
    private void viewStudentDetails() {
        System.out.println("\n--- View Student Details ---");
        System.out.print("Enter student ID: ");
        int id = getIntInput();

        Student student = gradeManager.findStudentById(id);
        if (student == null) {
            System.out.println("❌ Student with ID " + id + " not found!");
            return;
        }

        System.out.println("\n┌─ Student Information ─────────────────────┐");
        System.out.println("│ Name: " + padRight(student.getName(), 35) + "│");
        System.out.println("│ ID: " + padRight("" + student.getId(), 37) + "│");
        System.out.println("│ Number of Grades: " + padRight("" + student.getGradeCount(), 24) + "│");
        System.out.println("├───────────────────────────────────────────┤");

        if (student.getGradeCount() == 0) {
            System.out.println("│ No grades recorded yet                    │");
        } else {
            System.out.println("│ Average: " + padRight(String.format("%.2f", student.getAverageGrade()), 32) + "│");
            System.out.println("│ Highest: " + padRight(String.format("%.1f", student.getHighestGrade()), 32) + "│");
            System.out.println("│ Lowest: " + padRight(String.format("%.1f", student.getLowestGrade()), 33) + "│");
            System.out.println("│ Grade: " + padRight("" + student.getLetterGrade(), 34) + "│");

            List<Double> grades = student.getGrades();
            System.out.println("│ All Grades: " + padRight(grades.toString(), 28) + "│");
        }
        System.out.println("└───────────────────────────────────────────┘");
    }

    /**
     * Display summary report for all students
     */
    private void displaySummaryReport() {
        System.out.println("\n╔═ CLASS SUMMARY REPORT ═════════════════════╗");

        if (gradeManager.getStudentCount() == 0) {
            System.out.println("║ No students in the system.                 ║");
            System.out.println("╚════════════════════════════════════════════╝");
            return;
        }

        System.out.println("║ Total Students: " + padRight("" + gradeManager.getStudentCount(), 27) + "║");
        System.out.println("╟────────────────────────────────────────────╢");

        // Class statistics
        System.out.println("║ CLASS STATISTICS:                          ║");
        System.out.println("║ ├─ Class Average: " + padRight(String.format("%.2f", gradeManager.getClassAverage()), 24) + "║");
        System.out.println("║ ├─ Highest Grade: " + padRight(String.format("%.1f", gradeManager.getClassHighest()), 24) + "║");
        System.out.println("║ └─ Lowest Grade: " + padRight(String.format("%.1f", gradeManager.getClassLowest()), 25) + "║");
        System.out.println("╟────────────────────────────────────────────╢");

        // Top and bottom students
        Student topStudent = gradeManager.getTopStudent();
        Student bottomStudent = gradeManager.getBottomStudent();

        if (topStudent != null) {
            System.out.println("║ TOP PERFORMER:                             ║");
            System.out.println("║ ├─ Name: " + padRight(topStudent.getName(), 32) + "║");
            System.out.println("║ ├─ ID: " + padRight("" + topStudent.getId(), 34) + "║");
            System.out.println("║ └─ Average: " + padRight(String.format("%.2f", topStudent.getAverageGrade()), 30) + "║");
        }

        System.out.println("╟────────────────────────────────────────────╢");

        if (bottomStudent != null) {
            System.out.println("║ NEEDS IMPROVEMENT:                         ║");
            System.out.println("║ ├─ Name: " + padRight(bottomStudent.getName(), 32) + "║");
            System.out.println("║ ├─ ID: " + padRight("" + bottomStudent.getId(), 34) + "║");
            System.out.println("║ └─ Average: " + padRight(String.format("%.2f", bottomStudent.getAverageGrade()), 30) + "║");
        }

        System.out.println("╚════════════════════════════════════════════╝");
    }

    /**
     * List all students with their statistics
     */
    private void listAllStudents() {
        System.out.println("\n--- All Students ---");

        List<Student> students = gradeManager.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        System.out.println("┌────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ ID   │ Name               │ Avg    │ High  │ Low   │ Grade │ Count │");
        System.out.println("├────────────────────────────────────────────────────────────────────┤");

        for (Student student : students) {
            String row = String.format("│ %-4d │ %-18s │ %6.2f │ %5.1f │ %5.1f │ %5c │ %5d │",
                    student.getId(),
                    student.getName(),
                    student.getAverageGrade(),
                    student.getHighestGrade(),
                    student.getLowestGrade(),
                    student.getLetterGrade(),
                    student.getGradeCount());
            System.out.println(row);
        }

        System.out.println("└────────────────────────────────────────────────────────────────────┘");
    }

    /**
     * Remove a student from the system
     */
    private void removeStudent() {
        System.out.println("\n--- Remove Student ---");
        System.out.print("Enter student ID to remove: ");
        int id = getIntInput();

        Student student = gradeManager.findStudentById(id);
        if (student == null) {
            System.out.println("❌ Student with ID " + id + " not found!");
            return;
        }

        System.out.print("Are you sure you want to remove " + student.getName() + "? (yes/no): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("yes") || confirmation.equals("y")) {
            gradeManager.removeStudent(id);
            System.out.println("✓ Student removed successfully!");
        } else {
            System.out.println("Operation cancelled.");
        }
    }

    /**
     * Get integer input from user with validation
     */
    private int getIntInput() {
        try {
            int value = Integer.parseInt(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter a valid number.");
            return -1;
        }
    }

    /**
     * Get double input from user with validation
     */
    private double getDoubleInput() {
        try {
            double value = Double.parseDouble(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter a valid number.");
            return -1;
        }
    }

    /**
     * Utility method to pad right alignment for formatting
     */
    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    /**
     * Main method to start the application
     */
    public static void main(String[] args) {
        StudentGradeApp app = new StudentGradeApp();
        app.start();
    }
}
