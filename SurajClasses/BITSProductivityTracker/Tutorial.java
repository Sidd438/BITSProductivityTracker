package tracker.SurajClasses.BITSProductivityTracker;
import java.time.LocalTime;
import BITSProductivityTracker.Student;


public class Tutorial extends Event {

    public Tutorial(LocalTime starttime, LocalTime endtime, BITSProductivityTracker.Course course, String day) {
        super(starttime, endtime, course, day);
    }
}