package tracker.SurajClasses.BITSProductivityTracker;
import java.time.LocalTime;


public class Tutorial extends Event {

    public Tutorial(LocalTime starttime, LocalTime endtime, BITSProductivityTracker.Course course, String day) {
        super(starttime, endtime, course, day);
    }
}