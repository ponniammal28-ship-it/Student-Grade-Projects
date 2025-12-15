#!/bin/bash
# Run script for Student Grade Management System

# Check if compiled files exist
if [ ! -d "out" ] || [ ! -f "out/com/grades/StudentGradeApp.class" ]; then
    echo "Application not compiled. Building first..."
    ./build.sh
fi

# Run the application
echo "Starting Student Grade Management System..."
echo "==========================================="
echo ""

java -cp out com.grades.StudentGradeApp
