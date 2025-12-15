package com.grades;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student with their grades
 */
public class Student {
    private String name;
    private int id;
    private List<Double> grades;

    /**
     * Constructor for creating a new student
     * @param name Student's name
     * @param id Student's ID
     */
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    /**
     * Add a grade for the student
     * @param grade The grade to add (0-100)
     * @throws IllegalArgumentException if grade is invalid
     */
    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        grades.add(grade);
    }

    /**
     * Get the average grade
     * @return The average grade, or 0 if no grades exist
     */
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    /**
     * Get the highest grade
     * @return The highest grade, or 0 if no grades exist
     */
    public double getHighestGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double max = grades.get(0);
        for (double grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }

    /**
     * Get the lowest grade
     * @return The lowest grade, or 0 if no grades exist
     */
    public double getLowestGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double min = grades.get(0);
        for (double grade : grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
    }

    /**
     * Get all grades for the student
     * @return List of grades
     */
    public List<Double> getGrades() {
        return new ArrayList<>(grades);
    }

    /**
     * Get the number of grades
     * @return Number of grades
     */
    public int getGradeCount() {
        return grades.size();
    }

    /**
     * Get student's name
     * @return Student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get student's ID
     * @return Student's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Get letter grade based on average
     * @return Letter grade (A, B, C, D, F)
     */
    public char getLetterGrade() {
        double avg = getAverageGrade();
        if (avg >= 90) return 'A';
        if (avg >= 80) return 'B';
        if (avg >= 70) return 'C';
        if (avg >= 60) return 'D';
        return 'F';
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Avg: %.2f | Best: %.1f | Worst: %.1f | Grade: %c",
                id, name, getAverageGrade(), getHighestGrade(), getLowestGrade(), getLetterGrade());
    }
}
