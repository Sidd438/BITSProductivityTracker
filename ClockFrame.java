import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockFrame extends JFrame { //JFrame used in Swing to add all the components
    //private WorkTime myWorkTime;
    private ManipulateTime myManipulateTime;

    public static final int DEFAULT_WIDTH = 500;
    public static final int DEFAULT_HEIGHT = 200;
    private JLabel elapsedTimeLabel = new JLabel();
    private JSpinner dateSpinner;
    private JSpinner breakSpinner;

    public ClockFrame(){
        //constructor
        setTitle("Productivity Timer Log");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT); //change size here
        myManipulateTime = new ManipulateTime();

        //creating panels
        JPanel inputPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel outputPanel = new JPanel();

        //Labels

        JLabel startTimeLabel = new JLabel("Start Time");
        JLabel breakTimeLabel = new JLabel("Break Time");
        JLabel timeWorkedLabel = new JLabel("Total Productive time");
        elapsedTimeLabel = new JLabel("Get back to work!!!");

        //Buttons

        JButton runButton = new JButton("Run");

        //DateSpinner

        Date today = new Date();
        dateSpinner = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.HOUR_OF_DAY));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "DD/MM/YYYY HH:MM:SS");
        dateSpinner.setEditor(dateEditor);

        //break time spinner

        breakSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 600, 5));

        // Editor

        JSpinner.NumberEditor numberEditor = new JSpinner.NumberEditor(breakSpinner);
        breakSpinner.setEditor(numberEditor);

        //Details for panels

        inputPanel.add(startTimeLabel);
        inputPanel.add(dateSpinner);
        inputPanel.add(breakTimeLabel);
        inputPanel.add(breakSpinner);

        outputPanel.add(timeWorkedLabel);
        outputPanel.add(elapsedTimeLabel);

        buttonPanel.add(runButton);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To get date and time for spinner

                Date spinnerDate = (Date)dateSpinner.getValue();
                Integer breakMinutes = (Integer)breakSpinner.getValue();

                //To pass on dates and label information
                System.out.println("Spinner date: "+ spinnerDate);

                //To check how much time has passed
                myManipulateTime.setMyStartTimeDate(spinnerDate);
                myManipulateTime.setMyBreakMinutes(breakMinutes);
                myManipulateTime.setElapsedTimeLabel(elapsedTimeLabel);

                //multi-threading
                Thread t = new Thread(myManipulateTime);
                t.start();




            }
        };


        runButton.addActionListener(actionListener);
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(outputPanel, BorderLayout.SOUTH);


    }
}
