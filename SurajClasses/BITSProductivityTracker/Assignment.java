package tracker.SurajClasses.BITSProductivityTracker;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Assignment extends Test implements Serializable {

    public Assignment(LocalTime starttime, LocalTime endtime, String syllabus, int marks, int score, BITSProductivityTracker.Course course, String day, LocalDate date) {
        super(starttime, endtime, syllabus, marks, score, course, day, date);
    }
}