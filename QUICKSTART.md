# Quick Start Guide

## Overview
This is a complete Java Student Grade Management System with console-based UI, using ArrayLists for data management.

## Quick Commands

### Build the Project
```bash
./build.sh
# OR
javac -d out src/main/  /com/grades/*.java
```

### Run the Application
```bash
./run.sh
# OR
java -cp out com.grades.StudentGradeApp
```

### Run Demo with Sample Data
```bash
./test.sh
```

## Main Features

✓ Add/Remove Students with unique IDs  
✓ Add multiple grades per student with validation (0-100)  
✓ Calculate average, highest, and lowest grades  
✓ Assign letter grades (A-F) automatically  
✓ View individual student details  
✓ Display class summary report with statistics  
✓ Identify top performer and students needing help  
✓ List all students in formatted table  

## Core Classes

### Student.java (3.1 KB)
- Manages individual student data
- Stores grades in ArrayList
- Calculates statistics (average, high, low)
- Methods: addGrade(), getAverageGrade(), getLetterGrade(), etc.

### GradeManager.java (4.1 KB)
- Manages collection of students
- Provides class-level statistics
- Find, add, remove student operations
- Methods: addStudent(), getClassAverage(), getTopStudent(), etc.

### StudentGradeApp.java (14 KB)
- Console-based user interface
- Menu-driven navigation (7 options)
- Input validation and error handling
- Formatted output with visual boxes

## Usage Example

```
Welcome to Student Grade Management System

Main Menu:
1. Add a new student
2. Add a grade to a student
3. View student details
4. Display summary report
5. List all students
6. Remove a student
7. Exit

Enter your choice (1-7): 1

--- Add New Student ---
Enter student name: John Doe
Enter student ID: 101
✓ Student 'John Doe' added successfully!

Enter your choice (1-7): 2

--- Add Grade to Student ---
Enter student ID: 101
Enter grade (0-100): 85
✓ Grade added successfully for John Doe
```

## Grading Scale

| Grade | Range |
|-------|-------|
| A     | 90-100 |
| B     | 80-89  |
| C     | 70-79  |
| D     | 60-69  |
| F     | <60    |

## Data Structures Used

- **ArrayList<Student>**: Dynamic array of students
- **ArrayList<Double>**: Dynamic array of grades per student
- **Scanner**: User input handling

## Project Files

```
Student-Grade-Projects/
├── src/main/java/com/grades/
│   ├── Student.java           ← Individual student with grades
│   ├── GradeManager.java      ← Manages multiple students
│   └── StudentGradeApp.java   ← Main application & UI
├── out/                        ← Compiled .class files
├── build.sh                    ← Compilation script
├── run.sh                      ← Execution script
├── test.sh                     ← Demo with sample data
├── README.md                   ← Full documentation
└── IMPLEMENTATION.md           ← Technical details
```

## Key Methods Summary

### Student Methods
```java
addGrade(double grade)          // Add a grade
getAverageGrade()              // Calculate average
getHighestGrade()              // Get max grade
getLowestGrade()               // Get min grade
getLetterGrade()               // Get A-F grade
getGrades()                    // Get all grades list
getGradeCount()                // Count of grades
```

### GradeManager Methods
```java
addStudent(Student s)          // Add new student
removeStudent(int id)          // Remove student
findStudentById(int id)        // Search student
getClassAverage()              // Class average
getClassHighest()              // Highest in class
getClassLowest()               // Lowest in class
getTopStudent()                // Best performer
getBottomStudent()             // Needs most help
getAllStudents()               // Get all students
```

## Error Handling

The application validates:
- Grades must be 0-100 ✓
- Student IDs must be unique ✓
- Invalid numeric input ✓
- Non-existent student lookup ✓
- Empty student list operations ✓

## Requirements Met

✓ Input and manage student grades  
✓ Calculate average, highest, lowest scores  
✓ Use ArrayLists for storage  
✓ Display summary report  
✓ Console-based interface with menu system  
✓ Comprehensive error handling  
✓ Well-organized OOP design  
✓ Full documentation and examples  

## Next Steps

1. **Basic Usage**: Run `./run.sh` to start
2. **Demo**: Run `./test.sh` to see sample data
3. **Customization**: Edit source files for additional features
4. **Enhancement**: Add file I/O, GUI, or database integration

## Troubleshooting

**Error: "javac not found"**
- Install Java Development Kit (JDK 8+)

**Error: "No students in the system"**
- Add students first (Option 1 in menu)

**Error: "Grade must be between 0-100"**
- Enter valid grade value in range

**Scripts not executable**
- Run: `chmod +x *.sh`

## Support Features

- Full Javadoc comments in all classes
- Detailed implementation guide in IMPLEMENTATION.md
- Sample test data in test.sh
- Color-coded console output with success/error indicators
- Formatted table and report displays

## Performance Notes

- O(n) linear search for student lookup
- O(m) average grade calculation where m is grades per student
- O(n*m) for all operations on entire class
- Suitable for classes up to ~1000 students

## Future Enhancements

1. Save/load data to file (CSV, JSON)
2. GUI interface using Swing/JavaFX
3. Subject-wise grade tracking
4. Database integration (MySQL)
5. Grade distribution analytics
6. Email notifications
7. Web-based interface

---
**For detailed technical information, see IMPLEMENTATION.md**  
**For complete usage guide, see README.md**
