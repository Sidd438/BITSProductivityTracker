package BITSProductivityTracker;

public interface Addday {
    public void addMon();
    public void addTue();
    public void addWed();
    public void addThu();
    public void addFri();
    public void addSat();
    public void addSun();
}

public class Course implements Addday {
    public String name;
    public int marks;
    public float expected_cg;

    public Course(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public float getExpected_cg() {
        return expected_cg;
    }

    public void setExpected_cg(float expected_cg) {
        this.expected_cg = expected_cg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void addMon(){
        System.out.println("Monday");
    }

    public void addTue(){
        System.out.println("Tuesday");
    }

    public void addWed(){
        System.out.println("Wednesday");
    }

    public void addThu(){
        System.out.println("Thursday");
    }

    public void addFri(){
        System.out.println("Friday");
    }

    public void addSat(){
        System.out.println("Saturday");
    }

    public void addSun(){
        System.out.println("Sunday");
    }

}


public class Note {
    private String title;
    private String text;
    private Course course;

    public Note(String title, String text, Course course) {
        this.title = title;
        this.text = text;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Course getCourse() {
        return course;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


}