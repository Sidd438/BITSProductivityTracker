package tracker;

import tracker.SurajClasses.BITSProductivityTracker.Lecture;
import tracker.SurajClasses.BITSProductivityTracker.Tutorial;
import BITSProductivityTracker.Course;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
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

public class Schedule {
    JFrame f;
    // Table
    JTable j;
    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Schedule window = new Schedule();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Schedule() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        f = new JFrame();
        ArrayList<Tutorial> tuts = new ArrayList<>();
        ArrayList<Lecture> lecs = new ArrayList<>();
        Course course = new Course("OOPS", 200);
        LocalTime time = LocalTime.of(8, 9);
        LocalTime time2 = LocalTime.of(11, 9);
        LocalTime time3 = LocalTime.of(12, 9);
        tuts.add(new Tutorial(time, time2, course, "Monday"));
        lecs.add(new Lecture(time2, time3, course, "Tuesday"));
        // Frame Title
        f.setTitle("JTable Example");
        // Data to be displayed in the JTable
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
        HashMap<String, Integer> cac = new HashMap<>();
        cac.put("Monday", 1);
        cac.put("Tuesday", 2);
        cac.put("Wednesday", 3);
        cac.put("Thursday", 4);
        cac.put("Friday", 5);
        cac.put("Saturday", 6);
        cac.put("Sunday", 7);
        for(Tutorial tut : tuts){
            int hour = tut.getStarttime().getHour();
            int hourend = tut.getEndtime().getHour();
            String day = tut.day;
            int j = cac.get(day);
            for(int k = hour; k<hourend; k++){
                data[k-8][j] += ("Tutorial : " + tut.getCourse().getName() + " "+hour+"-"+hourend);
            }

        }
        for(Lecture tut : lecs){
            int hour = tut.getStarttime().getHour();
            int hourend = tut.getEndtime().getHour();
            String day = tut.day;
            int j = cac.get(day);
            for(int k = hour; k<hourend; k++){
                data[k-8][j] += ("Lecture : " + tut.getCourse().getName() + " "+hour+"-"+hourend);
            }

        }

        // Column Names
        String[] columnNames = { "Timings" , "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 4000, 1000);
        j.setRowHeight(78);
        // adding it to JScrollPane
        j.getColumnModel().getColumn(0).setPreferredWidth(3);
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(1000, 1000);
        // Frame Visible = true
        f.setVisible(true);
    }

}
