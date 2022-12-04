package tracker;

import tracker.SurajClasses.BITSProductivityTracker.*;
import BITSProductivityTracker.Course;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JPasswordField;

public class AddTests {
    JFrame f;
    // Table
    JTable j;
    JLabel l1, l2, l3, l4, l0, j1, j2, j3;
    JComboBox day;
    JButton add;
    JComboBox course, type;
    private JTextField textField;
    private JTextField syllabus;
    JSpinner start, end, marks;

    static ArrayList<Assignment> assignments = new ArrayList<>();
    static ArrayList<Midsem> midsems = new ArrayList<>();
    static ArrayList<Compre> compres = new ArrayList<>();
    static ArrayList<Quiz> quizzes = new ArrayList<>();



    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddTests window = new AddTests();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddTests() {
        initialize();
    }

    private void initialize() {
        String[][] data = {
                { "8 - 9", "", "","", "", "", "", "" }, // 0
                { "9 - 10", "", "","", "", "", "", "" }, // 1
                { "10 - 11", "", "","", "", "", "", "" }, // 2
                { "11 - 12", "", "","", "", "", "", "" }, // 3
                { "12 - 1", "", "","", "", "", "", "" }, // 4
                { "1 - 2", "", "","", "", "", "", "" }, // 5
                { "2 - 3", "", "","", "", "", "", "" }, // 6
                { "3 - 4", "", "","", "", "", "", "" }, // 7
                { "4 - 5", "", "","", "", "", "", "" }, // 8
                { "5 - 6", "", "","", "", "", "", "" }, // 9
        };
        String[] columnNames = { "Timings" , "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        HashMap<String, Integer> cac = new HashMap<>();
        cac.put("MONDAY", 1);
        cac.put("TUESDAY", 2);
        cac.put("WEDNESDAY", 3);
        cac.put("THURSDAY", 4);
        cac.put("FRIDAY", 5);
        cac.put("SATURDAY", 6);
        cac.put("SUNDAY", 7);
        f = new JFrame();
        f.setLayout(new FlowLayout());
        ArrayList<Course> courses = new ArrayList<>();
        courses.add((new Course("OOPS", 200)));
        ArrayList<String> cour = new ArrayList<>();
        for(Course course: courses){
            cour.add(course.name);
        }
        String[] types = {"Assignment", "Compre", "Midsem", "Quiz"};
        type = new JComboBox(types);
        day = new JComboBox(columnNames);
        course = new JComboBox(cour.toArray());
        l0 = new JLabel("Select Type");
        l1 = new JLabel("Select Day");
        l2 = new JLabel("Select Course");
        l3 = new JLabel("Start Hour");
        l4 = new JLabel("End Hour");
        j1 = new JLabel("Enter Marks");
        j2 = new JLabel("Enter Date (dd-mm-yyyy)");
        j3 = new JLabel("Enter Syllabus");
        start = new JSpinner();
        end = new JSpinner();
        marks = new JSpinner();
        textField = new JTextField();
        syllabus = new JTextField();
        textField.setSize(100, 100);
        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					@SuppressWarnings("deprecation")
					String s2=course.getSelectedItem().toString();
                    Course cur = new Course("No Course", 000);
                    for(Course course: courses){
                        if(course.name.equals(s2)){
                            cur = course;
                        }
                    }
                    int s3 = Integer.parseInt(start.getValue().toString());
                    int s4 = Integer.parseInt(end.getValue().toString());
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate date = LocalDate.parse(textField.getText(), dateFormat);
                    String s1 = String.valueOf(date.getDayOfWeek());
                    int s5 = Integer.parseInt(marks.getValue().toString());
                    String s6 = syllabus.getText();
                    boolean check = isDateInCurrentWeek(date);
                    Course finalCur = cur;
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if(type.getSelectedItem().toString().equals("Assignment")){
                        Assignment lecture = new Assignment( LocalTime.of(s3, 0), LocalTime.of(s4, 0), s6, s5, 0, finalCur, s1, date);
                        assignments.add(lecture);
                        System.out.println(check);
                        if(check){
                            int hour = lecture.getStarttime().getHour();
                            int hourend = lecture.getEndtime().getHour();
                            String day = lecture.day;
                            System.out.println(day);
                            int ja = cac.get(day);
                            for(int k = hour; k<hourend; k++){
                                j.getModel().setValueAt(("Assignment : " + lecture.getCourse().getName() + " "+hour+"-"+hourend),k-8,ja);
                            }
                        }
                    }else if(type.getSelectedItem().toString().equals("Compre")){
                        Compre lecture = new Compre( LocalTime.of(s3, 0), LocalTime.of(s4, 0), s6, s5, 0, finalCur, s1, date);
                        compres.add(lecture);
                        if(check){
                            int hour = lecture.getStarttime().getHour();
                            int hourend = lecture.getEndtime().getHour();
                            String day = lecture.day;
                            int ja = cac.get(day);
                            for(int k = hour; k<hourend; k++){
                                j.getModel().setValueAt(("Compre : " + lecture.getCourse().getName() + " "+hour+"-"+hourend),k-8,ja);
                            }
                        }
                    }else if(type.getSelectedItem().toString().equals("Midsem")){
                        Midsem lecture = new Midsem( LocalTime.of(s3, 0), LocalTime.of(s4, 0), s6, s5, 0, finalCur, s1, date);
                        midsems.add(lecture);
                        if(check){
                            int hour = lecture.getStarttime().getHour();
                            int hourend = lecture.getEndtime().getHour();
                            String day = lecture.day;
                            int ja = cac.get(day);
                            for(int k = hour; k<hourend; k++){
                                j.getModel().setValueAt(("Midsem : " + lecture.getCourse().getName() + " "+hour+"-"+hourend),k-8,ja);
                            }
                        }
                    }else if(type.getSelectedItem().toString().equals("Quiz")){
                        Quiz lecture = new Quiz( LocalTime.of(s3, 0), LocalTime.of(s4, 0), s6, s5, 0, finalCur, s1, date);
                        quizzes.add(lecture);
                        if(check){
                            int hour = lecture.getStarttime().getHour();
                            int hourend = lecture.getEndtime().getHour();
                            String day = lecture.day;
                            int ja = cac.get(day);
                            for(int k = hour; k<hourend; k++){
                                j.getModel().setValueAt(("Quiz : " + lecture.getCourse().getName() + " "+hour+"-"+hourend),k-8,ja);
                            }
                        }
                    }
                        }
                    });
                    thread.start();
                    
					//JOptionPane.showMessageDialog(null,"Username: "+s1+" Password: "+s2);
				}catch(Exception ex) {
                    System.out.println(ex.toString());
					JOptionPane.showMessageDialog(null,"Please Enter Valid details");
				}
			}
		});
        f.add(l0);
        f.add(type);
//        f.add(l1);
//        f.add(day);
        f.add(l2);
        f.add(course);
        f.add(l3);
        f.add(start);
        f.add(l4);
        f.add(end);
        f.add(j1);
        f.add(marks);
        f.add(j2);
        f.add(textField);
        f.add(j3);
        f.add(syllabus);
        f.add(btnNewButton);
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 4000, 1000);
        j.setRowHeight(78);
        // adding it to JScrollPane
//        j.getColumnModel().getColumn(0).setPreferredWidth(3);
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setSize(400, 400);
        f.setVisible(true);

    }

    public static boolean isDateInCurrentWeek(LocalDate localDate) {
    Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
  Calendar currentCalendar = Calendar.getInstance();
  int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
  int year = currentCalendar.get(Calendar.YEAR);
  Calendar targetCalendar = Calendar.getInstance();
  targetCalendar.setTime(date);
  int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
  int targetYear = targetCalendar.get(Calendar.YEAR);
  return week == targetWeek && year == targetYear;
}
}


class CheckWeekThread implements Runnable{

    private final LocalDate date;
    private boolean check = false;

    CheckWeekThread(LocalDate date){
        this.date = date;
    }

    @Override
    public void run() {
        LocalDate localDate = this.date;
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar currentCalendar = Calendar.getInstance();
        int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
        int year = currentCalendar.get(Calendar.YEAR);
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(date);
        int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
        int targetYear = targetCalendar.get(Calendar.YEAR);
        check = week == targetWeek && year == targetYear;
    }

    public boolean isCheck() {
        return check;
    }
}