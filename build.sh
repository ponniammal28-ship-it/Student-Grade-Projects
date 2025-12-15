#!/bin/bash
# Build script for Student Grade Management System

echo "Building Student Grade Management System..."
echo "==========================================="

# Create output directory
mkdir -p out

# Compile Java files
javac -d out src/main/java/com/grades/*.java

# Check compilation status
if [ $? -eq 0 ]; then
    echo ""
    echo "✓ Build successful!"
    echo ""
    echo "To run the application, use:"
    echo "  ./run.sh"
    echo ""
    echo "Or run directly with:"
    echo "  java -cp out com.grades.StudentGradeApp"
else
    echo ""
    echo "❌ Build failed!"
    exit 1
fi
