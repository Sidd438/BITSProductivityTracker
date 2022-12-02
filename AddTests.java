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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
        f = new JFrame();
        f.setLayout(new FlowLayout());
        ArrayList<Course> courses = new ArrayList<>();
        courses.add((new Course("OOPS", 200)));
        ArrayList<String> cour = new ArrayList<>();
        for(Course course: courses){
            cour.add(course.name);
        }
        String[] types = {"Assignment", "Compre", "Midsem", "Quiz"};

        String[] columnNames = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
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
					String s1=day.getSelectedItem().toString();
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
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(textField.getText(), dateFormat);
                    int s5 = Integer.parseInt(marks.getValue().toString());
                    String s6 = syllabus.getText();
                    if(type.getSelectedItem().toString().equals("Assignment")){
                        Assignment lecture = new Assignment( LocalTime.of(s3, 0), LocalTime.of(s4, 0), s6, s5, 0, cur, s1, date);
                        System.out.println(lecture);
                    }else if(type.getSelectedItem().toString().equals("Compre")){
                        Compre lecture = new Compre( LocalTime.of(s3, 0), LocalTime.of(s4, 0), s6, s5, 0, cur, s1, date);
                        System.out.println(lecture);
                    }else if(type.getSelectedItem().toString().equals("Midsem")){
                        Midsem lecture = new Midsem( LocalTime.of(s3, 0), LocalTime.of(s4, 0), s6, s5, 0, cur, s1, date);
                        System.out.println(lecture);
                    }else if(type.getSelectedItem().toString().equals("Quiz")){
                        Quiz lecture = new Quiz( LocalTime.of(s3, 0), LocalTime.of(s4, 0), s6, s5, 0, cur, s1, date);
                        System.out.println(lecture);
                    }
					//JOptionPane.showMessageDialog(null,"Username: "+s1+" Password: "+s2);
				}catch(Exception ex) {
                    System.out.println(ex.toString());
					JOptionPane.showMessageDialog(null,"Please Enter Valid details");
				}
			}
		});
        f.add(l0);
        f.add(type);
        f.add(l1);
        f.add(day);
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
        f.setSize(400, 400);
        f.setVisible(true);

    }
}