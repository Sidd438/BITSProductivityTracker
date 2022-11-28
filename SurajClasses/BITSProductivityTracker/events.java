package BITSProductivityTracker;

import java.time.LocalDate;
import course.Course;

public class Event {
    private LocalDate starttime;
    private LocalDate endtime;
    private Course course;

    public Event(LocalDate starttime, LocalDate endtime, Course course) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.course = course;
    }

    public LocalDate getStarttime() {
        return starttime;
    }

    public LocalDate getEndtime() {
        return endtime;
    }

    public void setStarttime(LocalDate starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(LocalDate endtime) {
        this.endtime = endtime;
    }

}

public class Test extends Event {
    private String name;
    private String syllabus;
    private int marks;
    private int score;


    public Test(LocalDate starttime, LocalDate endtime, String name, String syllabus, int marks, int score, Course course) {
        super(starttime, endtime, course);
        this.name = name;
        this.syllabus = syllabus;
        this.marks = marks;
        this.score = score;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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

public class Assignment extends Test{

    public Assignment(LocalDate starttime, LocalDate endtime, String name, String syllabus, int marks, int score, Course course) {
        super(starttime, endtime, name, syllabus, marks, score, course);
    }
}

public class Compre extends Test{

    public Compre(LocalDate starttime, LocalDate endtime, String name, String syllabus, int marks, int score, Course course) {
        super(starttime, endtime, name, syllabus, marks, score, course);
    }
}

public class Quiz extends Test{

    public Quiz(LocalDate starttime, LocalDate endtime, String name, String syllabus, int marks, int score, Course course) {
        super(starttime, endtime, name, syllabus, marks, score, course);
    }
}

public class Midsem extends Test{

    public Midsem(LocalDate starttime, LocalDate endtime, String name, String syllabus, int marks, int score, Course course) {
        super(starttime, endtime, name, syllabus, marks, score, course);
    }
}

public class Tutorial extends Event {

    public Tutorial(LocalDate starttime, LocalDate endtime, Course course) {
        super(starttime, endtime, course);
    }
}

public class Lecture extends Event {

    public Lecture(LocalDate starttime, LocalDate endtime, Course course) {
        super(starttime, endtime, course);
    }
}

