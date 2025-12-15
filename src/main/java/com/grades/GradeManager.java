package com.grades;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages multiple students and their grades
 */
public class GradeManager {
    private List<Student> students;

    /**
     * Constructor for GradeManager
     */
    public GradeManager() {
        this.students = new ArrayList<>();
    }

    /**
     * Add a new student to the system
     * @param student The student to add
     * @throws IllegalArgumentException if student ID already exists
     */
    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                throw new IllegalArgumentException("Student with ID " + student.getId() + " already exists");
            }
        }
        students.add(student);
    }

    /**
     * Remove a student by ID
     * @param studentId The ID of the student to remove
     * @return true if student was removed, false if not found
     */
    public boolean removeStudent(int studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == studentId) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Find a student by ID
     * @param studentId The ID to search for
     * @return The student, or null if not found
     */
    public Student findStudentById(int studentId) {
        for (Student s : students) {
            if (s.getId() == studentId) {
                return s;
            }
        }
        return null;
    }

    /**
     * Get all students
     * @return List of all students
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    /**
     * Get the number of students
     * @return Number of students
     */
    public int getStudentCount() {
        return students.size();
    }

    /**
     * Calculate class average
     * @return The average grade across all students
     */
    public double getClassAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double totalAverage = 0;
        for (Student s : students) {
            totalAverage += s.getAverageGrade();
        }
        return totalAverage / students.size();
    }

    /**
     * Get the highest grade in the entire class
     * @return The highest grade
     */
    public double getClassHighest() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double max = students.get(0).getHighestGrade();
        for (Student s : students) {
            double highest = s.getHighestGrade();
            if (highest > max) {
                max = highest;
            }
        }
        return max;
    }

    /**
     * Get the lowest grade in the entire class
     * @return The lowest grade
     */
    public double getClassLowest() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double min = students.get(0).getLowestGrade();
        for (Student s : students) {
            double lowest = s.getLowestGrade();
            if (lowest < min) {
                min = lowest;
            }
        }
        return min;
    }

    /**
     * Get top performer (highest average)
     * @return The student with highest average, or null if no students
     */
    public Student getTopStudent() {
        if (students.isEmpty()) {
            return null;
        }
        Student topStudent = students.get(0);
        for (Student s : students) {
            if (s.getAverageGrade() > topStudent.getAverageGrade()) {
                topStudent = s;
            }
        }
        return topStudent;
    }

    /**
     * Get student who needs most help (lowest average)
     * @return The student with lowest average, or null if no students
     */
    public Student getBottomStudent() {
        if (students.isEmpty()) {
            return null;
        }
        Student bottomStudent = students.get(0);
        for (Student s : students) {
            if (s.getAverageGrade() < bottomStudent.getAverageGrade()) {
                bottomStudent = s;
            }
        }
        return bottomStudent;
    }
}
