# Student Grade Management System

A comprehensive Java application for managing student grades with features for data storage, calculation of statistics, and detailed reporting.

## Features

✓ **Student Management**
- Add new students with unique IDs
- Remove students from the system
- View detailed student information

✓ **Grade Management**
- Add multiple grades for each student
- Automatic validation (grades must be 0-100)
- View all grades for a student

✓ **Statistical Analysis**
- Calculate average, highest, and lowest grades for each student
- Calculate class-wide averages and statistics
- Automatic letter grade assignment (A-F)

✓ **Reporting**
- View individual student details
- Display comprehensive class summary reports
- List all students with key statistics
- Identify top performer and student needing improvement

✓ **User Interface**
- Menu-driven console interface
- Formatted output with visual boxes
- Input validation and error handling

## Project Structure

```
Student-Grade-Projects/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── grades/
│                   ├── Student.java           # Student class with grade tracking
│                   ├── GradeManager.java      # Manages multiple students
│                   └── StudentGradeApp.java   # Main console application
└── README.md
```

## Classes Overview

### Student.java
Represents a single student with their grades.

**Key Methods:**
- `addGrade(double grade)` - Add a grade for the student
- `getAverageGrade()` - Calculate average of all grades
- `getHighestGrade()` - Get the highest grade
- `getLowestGrade()` - Get the lowest grade
- `getLetterGrade()` - Get letter grade based on average (A-F)
- `getGrades()` - Get list of all grades

### GradeManager.java
Manages multiple students and provides class-level statistics.

**Key Methods:**
- `addStudent(Student student)` - Add a new student
- `removeStudent(int studentId)` - Remove a student by ID
- `findStudentById(int studentId)` - Search for a student
- `getClassAverage()` - Calculate class average
- `getClassHighest()` - Get highest grade in class
- `getClassLowest()` - Get lowest grade in class
- `getTopStudent()` - Get student with highest average
- `getBottomStudent()` - Get student with lowest average

### StudentGradeApp.java
Main application with console-based menu interface.

**Features:**
- Menu-driven navigation
- Input validation
- Formatted output display
- Exception handling

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any text editor or IDE (Visual Studio Code, IntelliJ IDEA, Eclipse, etc.)

### Compilation

**Using Command Line:**
```bash
# Navigate to the project directory
cd Student-Grade-Projects

# Compile all Java files
javac -d out src/main/java/com/grades/*.java
```

**Using an IDE:**
- Import the project into your IDE
- The IDE will automatically compile the files

### Running the Application

```bash
# From the project directory
java -cp out com.grades.StudentGradeApp
```

## Usage Guide

### Main Menu Options

1. **Add a new student**
   - Enter student name and unique ID
   - Student is created with no grades initially

2. **Add a grade to a student**
   - Enter the student ID
   - Enter a grade (0-100)
   - Grade is added to student's record

3. **View student details**
   - Enter student ID
   - Displays all information including:
     - Average grade
     - Highest and lowest grades
     - Letter grade
     - All individual grades

4. **Display summary report**
   - Shows class-wide statistics
   - Displays total number of students
   - Shows class average, highest, and lowest grades
   - Identifies top performer and student needing improvement

5. **List all students**
   - Displays table of all students
   - Shows ID, name, average, high, low, letter grade, and count

6. **Remove a student**
   - Enter student ID
   - Confirm removal
   - Student is deleted from system

7. **Exit**
   - Closes the application

## Example Session

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

Enter your choice (1-7): 4

╔═ CLASS SUMMARY REPORT ═════════════════════╗
║ Total Students: 1                         ║
╟────────────────────────────────────────────╢
║ CLASS STATISTICS:                          ║
║ ├─ Class Average: 85.00                   ║
║ ├─ Highest Grade: 85.0                    ║
║ └─ Lowest Grade: 85.0                     ║
╟────────────────────────────────────────────╢
║ TOP PERFORMER:                             ║
║ ├─ Name: John Doe                         ║
║ ├─ ID: 101                                ║
║ └─ Average: 85.00                         ║
╚════════════════════════════════════════════╝
```

## Error Handling

The application includes robust error handling for:
- Invalid input (non-numeric grades)
- Grade validation (0-100 range)
- Duplicate student IDs
- Non-existent student lookups
- Empty student lists

## Data Structures Used

- **ArrayList**: Used for storing multiple students and grades
  - Provides dynamic sizing
  - Easy insertion and removal
  - Efficient iteration

- **Arrays (implicit)**: Used internally for calculations

## Grading Scale

- **A**: 90-100
- **B**: 80-89
- **C**: 70-79
- **D**: 60-69
- **F**: Below 60

## Technical Details

- **Language**: Java
- **Build Type**: Source compilation
- **Package Structure**: `com.grades`
- **Architecture**: Object-oriented with separation of concerns
- **Input**: Console (Scanner)
- **Output**: Console with formatted text

## Future Enhancement Ideas

- File I/O to save/load student data
- GUI interface using Swing or JavaFX
- Subject-wise grade tracking
- Generate PDF reports
- Database integration (MySQL, SQLite)
- Email notifications for grade updates
- Search and filter functionality
- Grade distribution analytics
- Export to CSV/Excel

## License

This project is provided as-is for educational purposes.

## Author

Created as a Java programming exercise for student grade management.
<<<<<<< HEAD
=======
## License

This project is provided as-is for educational purposes.

## Author
>>>>>>> d92c5ca (Add source files, documentation, and scripts for Student Grade Management System)

Created as a Java programming exercise for student grade management.
