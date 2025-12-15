# Architecture & Design Documentation

## System Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                    StudentGradeApp                          │
│                  (User Interface Layer)                      │
│                                                              │
│  - Menu-driven console interaction                          │
│  - Input validation and error handling                      │
│  - Formatted output display                                 │
└──────────────────────┬──────────────────────────────────────┘
                       │
                       ▼
┌─────────────────────────────────────────────────────────────┐
│                    GradeManager                             │
│              (Business Logic Layer)                         │
│                                                              │
│  - Manages collection of students                           │
│  - Class-level statistics                                   │
│  - Student search and management                            │
└──────────┬───────────────────────────────────┬──────────────┘
           │                                   │
           ▼                                   ▼
    ┌─────────────┐                    ┌─────────────┐
    │  Student 1  │                    │  Student N  │
    │             │                    │             │
    │  ArrayList  │                    │  ArrayList  │
    │  <Grades>   │                    │  <Grades>   │
    └─────────────┘                    └─────────────┘
           │                                   │
           ▼                                   ▼
    ┌──────────────┐                  ┌──────────────┐
    │Grade 1 - 100 │                  │Grade 1 -  95 │
    │Grade 2 -  95 │                  │Grade 2 -  92 │
    │Grade 3 -  88 │                  │Grade 3 -  98 │
    └──────────────┘                  └──────────────┘
```

## Class Diagram (UML-style)

```
┌────────────────────────────────┐
│         Student                │
├────────────────────────────────┤
│ - name: String                 │
│ - id: int                       │
│ - grades: List<Double>          │
├────────────────────────────────┤
│ + addGrade(double): void        │
│ + getAverageGrade(): double     │
│ + getHighestGrade(): double     │
│ + getLowestGrade(): double      │
│ + getLetterGrade(): char        │
│ + getGrades(): List<Double>     │
│ + getGradeCount(): int          │
│ + getName(): String             │
│ + getId(): int                  │
└────────────────────────────────┘

┌──────────────────────────────────┐
│       GradeManager               │
├──────────────────────────────────┤
│ - students: List<Student>        │
├──────────────────────────────────┤
│ + addStudent(Student): void      │
│ + removeStudent(int): boolean    │
│ + findStudentById(int): Student  │
│ + getAllStudents(): List         │
│ + getStudentCount(): int         │
│ + getClassAverage(): double      │
│ + getClassHighest(): double      │
│ + getClassLowest(): double       │
│ + getTopStudent(): Student       │
│ + getBottomStudent(): Student    │
└──────────────────────────────────┘
         ▲
         │ uses
         │ (contains)
         │
    0..*│
┌──────────────────────────────────┐
│     StudentGradeApp              │
├──────────────────────────────────┤
│ - gradeManager: GradeManager     │
│ - scanner: Scanner               │
├──────────────────────────────────┤
│ + start(): void                  │
│ + displayMainMenu(): void        │
│ + addNewStudent(): void          │
│ + addGradeToStudent(): void      │
│ + viewStudentDetails(): void     │
│ + displaySummaryReport(): void   │
│ + listAllStudents(): void        │
│ + removeStudent(): void          │
│ + main(String[]): void           │
└──────────────────────────────────┘
```

## Data Flow Diagram

```
User Input
    │
    ▼
┌──────────────────┐
│  Scanner Input   │     Validation
│  - Student name  │────────────────┐
│  - Student ID    │                │
│  - Grade value   │                ▼
└──────────────────┘         ┌──────────────┐
    │                        │ Bounds Check │
    │                        │ Duplicate ID │
    │                        │ Range Check  │
    │                        └──────────────┘
    │                               │
    ▼                               ▼
┌──────────────────┐        ┌──────────────┐
│  GradeManager    │        │ Valid? (Y/N) │
│  + addStudent()  │◄───────┴──────────────┘
│  + addGrade()    │
│  + findStudent() │
└──────────────────┘
    │
    ▼
┌──────────────────┐
│  Student List    │
│  (ArrayList)     │
│  - ID:101 Alice  │
│  - ID:102 Bob    │
│  - ID:103 Chali  │
└──────────────────┘
    │
    ▼
┌──────────────────┐
│ Calculate Stats  │
│ - Average        │
│ - Highest        │
│ - Lowest         │
│ - Letter Grade   │
└──────────────────┘
    │
    ▼
┌──────────────────┐
│ Formatted Output │
│ - Console Display│
│ - Tables         │
│ - Reports        │
└──────────────────┘
```

## Sequence Diagram - Adding a Grade

```
User        StudentGradeApp    GradeManager    Student    ArrayList
 │                 │                 │            │           │
 │─ Enter Grade ──>│                 │            │           │
 │                 │─ Find Student ─>│            │           │
 │                 │<─ Return Student│            │           │
 │                 │                 │ Add Grade ─>│           │
 │                 │                 │            │ Add Grade ─>│
 │                 │                 │            │<─ Success  │
 │                 │<─ Success ─────┬┴────────────┘           │
 │<─ Success Msg ─┬┴────────────────┘                         │
 │                 │
```

## Sequence Diagram - Display Summary Report

```
User        StudentGradeApp    GradeManager    Student
 │                 │                 │            │
 │─ Option 4 ────>│                 │            │
 │                 │─ Get All Stats ─>│           │
 │                 │<─ Class Avg   ──┬│           │
 │                 │<─ Class High  ──┤│           │
 │                 │<─ Class Low   ──┤│           │
 │                 │─ Get Top ────────>│           │
 │                 │<─ Top Student ──┬│           │
 │                 │─ Get Bottom ─────>│           │
 │                 │<─ Bottom Student ┤│           │
 │<─ Display Report┴┴────────────────┴┴───────────┘
```

## Control Flow - Main Application

```
Start
  │
  ▼
Create GradeManager
  │
  ▼
Show Welcome Message
  │
  ▼
┌─────────────────┐
│   Main Loop     │
│  running = true │
├─────────────────┤
│                 │
│ Display Menu    │
│      ▼          │
│ Get Choice      │
│      │          │
│      ▼          │
│  ┌─────────────┐│
│  │ Switch(ch)  ││
│  ├─────────────┤│
│  │ Case 1: Add ││
│  │ Case 2: Add ││
│  │ Case 3: View││
│  │ Case 4: Rpt ││
│  │ Case 5: List││
│  │ Case 6: Del ││
│  │ Case 7: Exit│ ← running = false
│  └─────────────┘│
│                 │
│   Loop Again    │
└─────────────────┘
  │
  ▼
Close Scanner
  │
  ▼
End
```

## State Management

```
Application States:
│
├─ IDLE (Waiting for menu choice)
│   ├─ Add Student State
│   │  └─ Enter Name → Enter ID → Back to IDLE
│   │
│   ├─ Add Grade State
│   │  └─ Enter Student ID → Enter Grade → Back to IDLE
│   │
│   ├─ View Details State
│   │  └─ Enter Student ID → Display → Back to IDLE
│   │
│   ├─ Display Report State
│   │  └─ Calculate Stats → Display → Back to IDLE
│   │
│   ├─ List All State
│   │  └─ Format All Students → Display → Back to IDLE
│   │
│   ├─ Remove Student State
│   │  └─ Enter ID → Confirm → Delete → Back to IDLE
│   │
│   └─ Exit State → End Application
```

## Component Interactions

```
┌─────────────────────────────────────────────────────┐
│         StudentGradeApp (UI Layer)                  │
├─────────────────────────────────────────────────────┤
│                                                     │
│  Menu Options (7)                                  │
│  ├─ Add Student      ┐                             │
│  ├─ Add Grade        │                             │
│  ├─ View Details     │─── Call GradeManager       │
│  ├─ Summary Report   │    Methods                  │
│  ├─ List All         │                             │
│  ├─ Remove Student   ┘                             │
│  └─ Exit                                           │
│                                                     │
└─────────────────────────────────────────────────────┘
                      │
              Uses/Calls Methods
                      │
                      ▼
┌─────────────────────────────────────────────────────┐
│         GradeManager (Business Logic)               │
├─────────────────────────────────────────────────────┤
│                                                     │
│  Student Management        Class Statistics       │
│  ├─ add(Student)          ├─ getClassAverage()   │
│  ├─ remove(id)            ├─ getClassHighest()   │
│  ├─ find(id)              ├─ getClassLowest()    │
│  └─ getAll()              ├─ getTopStudent()     │
│                           └─ getBottomStudent()  │
│                                                     │
└─────────────────────────────────────────────────────┘
                      │
              Manages/Contains
                      │
                      ▼
┌─────────────────────────────────────────────────────┐
│            Student Collection (Data)                │
├─────────────────────────────────────────────────────┤
│                                                     │
│  ArrayList<Student> students                      │
│  ├─ Student(101, "Alice")                         │
│  │  └─ grades: [85, 90, 88]                       │
│  ├─ Student(102, "Bob")                           │
│  │  └─ grades: [78, 82, 80]                       │
│  └─ Student(103, "Charlie")                       │
│     └─ grades: [95, 92, 98]                       │
│                                                     │
└─────────────────────────────────────────────────────┘
```

## Package Structure

```
com.grades/
│
├── Student.java
│   ├── Instance Variables
│   │   ├─ name: String
│   │   ├─ id: int
│   │   └─ grades: ArrayList<Double>
│   │
│   ├── Constructors
│   │   └─ Student(String, int)
│   │
│   ├── Grade Management
│   │   ├─ addGrade(double)
│   │   └─ getGrades()
│   │
│   ├── Statistics
│   │   ├─ getAverageGrade()
│   │   ├─ getHighestGrade()
│   │   ├─ getLowestGrade()
│   │   └─ getLetterGrade()
│   │
│   └── Accessors
│       ├─ getName()
│       ├─ getId()
│       └─ getGradeCount()
│
├── GradeManager.java
│   ├── Instance Variables
│   │   └─ students: ArrayList<Student>
│   │
│   ├── Constructors
│   │   └─ GradeManager()
│   │
│   ├── Student Management
│   │   ├─ addStudent(Student)
│   │   ├─ removeStudent(int)
│   │   ├─ findStudentById(int)
│   │   └─ getAllStudents()
│   │
│   ├── Class Statistics
│   │   ├─ getClassAverage()
│   │   ├─ getClassHighest()
│   │   ├─ getClassLowest()
│   │   ├─ getTopStudent()
│   │   └─ getBottomStudent()
│   │
│   └── Utility
│       └─ getStudentCount()
│
└── StudentGradeApp.java
    ├── Instance Variables
    │   ├─ gradeManager: GradeManager
    │   └─ scanner: Scanner
    │
    ├── Main Entry Point
    │   └─ main(String[])
    │
    ├── Application Control
    │   ├─ start()
    │   └─ displayMainMenu()
    │
    ├── Menu Operations
    │   ├─ addNewStudent()
    │   ├─ addGradeToStudent()
    │   ├─ viewStudentDetails()
    │   ├─ displaySummaryReport()
    │   ├─ listAllStudents()
    │   └─ removeStudent()
    │
    └── Utility Methods
        ├─ getIntInput()
        ├─ getDoubleInput()
        └─ padRight(String, int)
```

## Technology Stack

```
┌────────────────────────────────┐
│     Technology Stack            │
├────────────────────────────────┤
│ Language:      Java SE 8+       │
│ Collections:   ArrayList        │
│ Input:         Scanner          │
│ Output:        Console (stdout) │
│ Architecture:  OOP              │
│ Design:        MVC Pattern*     │
│ Build:         javac            │
│ Execution:     JVM              │
└────────────────────────────────┘

* Modified MVC:
  Model  → Student + GradeManager (Data & Logic)
  View   → StudentGradeApp console output
  Control→ StudentGradeApp menu handling
```

## Design Patterns Used

```
1. Encapsulation Pattern
   ├─ Private variables with public getters
   ├─ Data validation in setters
   └─ Controlled access to internal state

2. Single Responsibility Pattern
   ├─ Student: Manages single student
   ├─ GradeManager: Manages collection
   └─ StudentGradeApp: Handles UI

3. Collections Pattern
   ├─ ArrayList for dynamic sizing
   ├─ List interface for abstraction
   └─ For-each loops for iteration

4. Exception Handling Pattern
   ├─ IllegalArgumentException for invalid input
   ├─ Try-catch for input parsing
   └─ Null checks before operations

5. Separation of Concerns
   ├─ Logic separated from UI
   ├─ Data operations separate from display
   └─ Easy to extend or refactor
```

---

**For more details, see IMPLEMENTATION.md and QUICKSTART.md**
