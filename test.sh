#!/bin/bash
# Test script to demonstrate the Student Grade Management System

echo "===== Student Grade Management System - Demo Test ====="
echo ""
echo "This script will demonstrate the application with sample data."
echo ""

# Compile if needed
if [ ! -f "out/com/grades/StudentGradeApp.class" ]; then
    echo "Compiling..."
    javac -d out src/main/java/com/grades/*.java
fi

echo "Running interactive demo..."
echo ""
echo "Demo Input Sequence:"
echo "1. Add student: Alice (ID: 101)"
echo "2. Add grades: 85, 90, 88"
echo "3. Add student: Bob (ID: 102)"
echo "4. Add grades: 78, 82, 80"
echo "5. Add student: Charlie (ID: 103)"
echo "6. Add grades: 95, 92, 98"
echo "7. List all students"
echo "8. Display summary report"
echo "9. Exit"
echo ""
echo "==========================================="
echo ""

# Input sequence for demo
{
    echo "1"      # Add student
    sleep 0.5
    echo "Alice"  # Name
    sleep 0.5
    echo "101"    # ID
    sleep 0.5
    
    echo "2"      # Add grade
    sleep 0.5
    echo "101"    # Student ID
    sleep 0.5
    echo "85"     # Grade
    sleep 0.5
    
    echo "2"      # Add another grade
    sleep 0.5
    echo "101"    # Student ID
    sleep 0.5
    echo "90"     # Grade
    sleep 0.5
    
    echo "2"      # Add another grade
    sleep 0.5
    echo "101"    # Student ID
    sleep 0.5
    echo "88"     # Grade
    sleep 0.5
    
    echo "1"      # Add student
    sleep 0.5
    echo "Bob"    # Name
    sleep 0.5
    echo "102"    # ID
    sleep 0.5
    
    echo "2"      # Add grade
    sleep 0.5
    echo "102"    # Student ID
    sleep 0.5
    echo "78"     # Grade
    sleep 0.5
    
    echo "2"      # Add another grade
    sleep 0.5
    echo "102"    # Student ID
    sleep 0.5
    echo "82"     # Grade
    sleep 0.5
    
    echo "2"      # Add another grade
    sleep 0.5
    echo "102"    # Student ID
    sleep 0.5
    echo "80"     # Grade
    sleep 0.5
    
    echo "1"      # Add student
    sleep 0.5
    echo "Charlie"  # Name
    sleep 0.5
    echo "103"      # ID
    sleep 0.5
    
    echo "2"      # Add grade
    sleep 0.5
    echo "103"    # Student ID
    sleep 0.5
    echo "95"     # Grade
    sleep 0.5
    
    echo "2"      # Add another grade
    sleep 0.5
    echo "103"    # Student ID
    sleep 0.5
    echo "92"     # Grade
    sleep 0.5
    
    echo "2"      # Add another grade
    sleep 0.5
    echo "103"    # Student ID
    sleep 0.5
    echo "98"     # Grade
    sleep 0.5
    
    echo "5"      # List all students
    sleep 1
    
    echo "4"      # Display summary report
    sleep 1
    
    echo "7"      # Exit
} | java -cp out com.grades.StudentGradeApp

echo ""
echo "==========================================="
echo "Demo completed!"
