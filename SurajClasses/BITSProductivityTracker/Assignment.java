package tracker.SurajClasses.BITSProductivityTracker;
import java.time.LocalDate;
import java.time.LocalTime;

public class Assignment extends Test{

    public Assignment(LocalTime starttime, LocalTime endtime, String name, String syllabus, int marks, int score, BITSProductivityTracker.Course course, String day, LocalDate date) {
        super(starttime, endtime, name, syllabus, marks, score, course, day, date);
    }
}