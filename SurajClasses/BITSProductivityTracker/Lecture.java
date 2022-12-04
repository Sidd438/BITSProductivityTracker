package tracker.SurajClasses.BITSProductivityTracker;
import java.time.LocalTime;

public class Lecture extends Event {

    public Lecture(LocalTime starttime, LocalTime endtime, BITSProductivityTracker.Course course, String day) {
        super(starttime, endtime, course, day);
    }
}

