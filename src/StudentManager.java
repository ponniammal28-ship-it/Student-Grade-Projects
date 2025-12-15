import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public boolean addStudent(String name) {
        if (findStudent(name) != null) return false;
        students.add(new Student(name));
        return true;
    }

    public Student findStudent(String name) {
        for (Student s : students) if (s.getName().equalsIgnoreCase(name)) return s;
        return null;
    }

    public boolean removeStudent(String name) {
        Student s = findStudent(name);
        if (s == null) return false;
        students.remove(s);
        return true;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String summaryReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Summary Report\n");
        sb.append("----------------------\n");
        if (students.isEmpty()) {
            sb.append("No students.\n");
            return sb.toString();
        }

        double totalSum = 0;
        int totalCount = 0;
        Integer highestAll = null;
        Integer lowestAll = null;

        for (Student s : students) {
            sb.append(s.toString()).append("\n");
            for (int sc : s.getScores()) {
                totalSum += sc; totalCount++;
                highestAll = (highestAll == null || sc > highestAll) ? sc : highestAll;
                lowestAll = (lowestAll == null || sc < lowestAll) ? sc : lowestAll;
            }
        }

        sb.append("----------------------\n");
        if (totalCount == 0) {
            sb.append("No scores entered yet.\n");
        } else {
            double avgAll = totalSum / totalCount;
            sb.append(String.format("Class Average: %.2f\n", avgAll));
            sb.append("Highest Score: ").append(highestAll).append("\n");
            sb.append("Lowest Score: ").append(lowestAll).append("\n");
        }

        return sb.toString();
    }
}
