package tracker.SurajClasses.BITSProductivityTracker;

import java.time.LocalTime;
import BITSProductivityTracker.Course;
abstract public class Event {
    private LocalTime starttime;
    private LocalTime endtime;
    private Course course;
    public String day;

    public Event(LocalTime starttime, LocalTime endtime, Course course, String day) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.course = course;
        this.day = day;
    }

    public LocalTime getStarttime() {
        return starttime;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

}




