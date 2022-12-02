package tracker;

import tracker.SurajClasses.BITSProductivityTracker.Lecture;
import tracker.SurajClasses.BITSProductivityTracker.Tutorial;
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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.HashMap;
import javax.swing.JPasswordField;


public class AddClasses {
    JFrame f;
    // Table
    JTable j;
    JLabel l1, l2, l3, l4, l0;
    JComboBox day;
    JButton add;
    JComboBox course, type;
    JSpinner start, end;



    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddClasses window = new AddClasses();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddClasses() {
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
        String[] types = {"Lecture", "Tutorial"};

        String[] columnNames = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        type = new JComboBox(types);
        day = new JComboBox(columnNames);
        course = new JComboBox(cour.toArray());
        l0 = new JLabel("Select Type");
        l1 = new JLabel("Select Day");
        l2 = new JLabel("Select Course");
        l3 = new JLabel("Start Hour");
        l4 = new JLabel("End Hour");
        start = new JSpinner();
        end = new JSpinner();
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
                    if(type.getSelectedItem().toString().equals("Lecture")){
                        Lecture lecture = new Lecture( LocalTime.of(s3, 0), LocalTime.of(s4, 0), cur, s1);
                        System.out.println(lecture);
                    }
                    else{
                        Tutorial tutorial = new Tutorial( LocalTime.of(s3, 0), LocalTime.of(s4, 0), cur, s1);
                        System.out.println(tutorial);
                    }
					//JOptionPane.showMessageDialog(null,"Username: "+s1+" Password: "+s2);
				}catch(Exception ex) {
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
        f.add(btnNewButton);
        f.setSize(400, 400);
        f.setVisible(true);

    }
}
