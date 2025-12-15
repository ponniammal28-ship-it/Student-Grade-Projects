import java.util.ArrayList;
import java.util.Collections;

public class Student {
    private String name;
    private ArrayList<Integer> scores;

    public Student(String name) {
        this.name = name;
        this.scores = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addScore(int s) {
        if (s >= 0) scores.add(s);
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public double getAverage() {
        if (scores.isEmpty()) return 0.0;
        double sum = 0;
        for (int v : scores) sum += v;
        return sum / scores.size();
    }

    public int getHighest() {
        if (scores.isEmpty()) return Integer.MIN_VALUE;
        return Collections.max(scores);
    }

    public int getLowest() {
        if (scores.isEmpty()) return Integer.MAX_VALUE;
        return Collections.min(scores);
    }

    @Override
    public String toString() {
        String avg = String.format("%.2f", getAverage());
        return name + " | scores=" + scores + " | avg=" + avg;
    }
}
