import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager mgr = new StudentManager();

        while (true) {
            System.out.println("\nStudent Grades Manager");
            System.out.println("1) Add student");
            System.out.println("2) Add score to student");
            System.out.println("3) Remove student");
            System.out.println("4) List students");
            System.out.println("5) Summary report");
            System.out.println("6) Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Student name: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) { System.out.println("Name required."); break; }
                    boolean added = mgr.addStudent(name);
                    System.out.println(added ? "Added " + name : "Student already exists.");
                    break;
                case "2":
                    System.out.print("Student name: ");
                    String sname = sc.nextLine().trim();
                    Student s = mgr.findStudent(sname);
                    if (s == null) { System.out.println("Student not found."); break; }
                    System.out.print("Score (0-100): ");
                    String scStr = sc.nextLine().trim();
                    try {
                        int score = Integer.parseInt(scStr);
                        if (score < 0 || score > 100) { System.out.println("Score out of range."); break; }
                        s.addScore(score);
                        System.out.println("Score added.");
                    } catch (NumberFormatException e) { System.out.println("Invalid score."); }
                    break;
                case "3":
                    System.out.print("Student name: ");
                    String rname = sc.nextLine().trim();
                    boolean removed = mgr.removeStudent(rname);
                    System.out.println(removed ? "Removed " + rname : "Student not found.");
                    break;
                case "4":
                    if (mgr.getStudents().isEmpty()) System.out.println("No students.");
                    else {
                        System.out.println("Students:");
                        for (Student st : mgr.getStudents()) System.out.println(" - " + st.getName());
                    }
                    break;
                case "5":
                    System.out.println(mgr.summaryReport());
                    break;
                case "6":
                    System.out.println("Goodbye.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
