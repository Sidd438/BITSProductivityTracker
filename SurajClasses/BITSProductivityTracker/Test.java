package tracker.SurajClasses.BITSProductivityTracker;
import java.time.LocalDate;
import java.time.LocalTime;
import BITSProductivityTracker.Student;

public class Test extends Event {
    private String syllabus;
    private int marks;
    private int score;

    private LocalDate date;


    public Test(LocalTime starttime, LocalTime endtime, String syllabus, int marks, int score, BITSProductivityTracker.Course course, String day, LocalDate date) {
        super(starttime, endtime, course, day);
        this.syllabus = syllabus;
        this.marks = marks;
        this.score = score;
        this.date = date;
    }


    public String getSyllabus() {
        return syllabus;
    }

    public int getMarks() {
        return marks;
    }

    public int getScore() {
        return score;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setScore(int score) {
        this.score = score;
    }   


}