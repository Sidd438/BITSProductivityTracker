package tracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BITSProductiveTimeTracker extends JFrame {

    // GUI components
    private JLabel timeLabel;
    private JTextField breakDurationField;
    private JButton startButton;
    private JButton stopButton;
    private JButton addBreakButton;
    private JButton resetButton;
    private JLabel productiveTimeLabel;

    // Timer for tracking productive time, by calling the timer class
     Timer timer;

    // Counter for tracking productive time
    private int timeCounter;

    // Flag for tracking whether the timer is currently running
    private boolean timerRunning;

    public BITSProductiveTimeTracker() {
        // Set up the frame
        setTitle("BITS Productive Time Tracker");
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);  // center the frame on the screen

        // Create the time label
        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);



        breakDurationField = new JTextField(10);
        breakDurationField.setText("Enter Break Minutes here");


        startButton = new JButton("Start");
        startButton.addActionListener(e -> startTimer());


        stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> stopTimer());


        addBreakButton = new JButton("Add Break(in minutes)");
        addBreakButton.addActionListener(e -> addBreak());


        resetButton = new JButton("RESET");
        resetButton.addActionListener(e -> reset());


        JPanel panel = new JPanel();
        panel.add(timeLabel);
        panel.add(breakDurationField);
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(addBreakButton);
        panel.add(resetButton);
       // panel.add(productiveTimeLabel);


        add(panel);

        timer = new Timer(1000, e -> {
            timeCounter++;
            updateTimeLabel();
        });
        timeCounter = 0;


        updateTimeLabel();
        breakDurationField.setEnabled(false);
        addBreakButton.setEnabled(false);


        setVisible(true);
    }

    private void startTimer() {
        // Start the timer and update the GUI accordingly
        timer.start();
        timerRunning = true;
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        breakDurationField.setEnabled(true);
        addBreakButton.setEnabled(true);
    }

    private void  stopTimer() {
        // Stop the timer and update the GUI accordingly
        timer.stop();
        timerRunning = false;
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        breakDurationField.setEnabled(false);
        addBreakButton.setEnabled(false);
        int hours = timeCounter / 3600;
        int minutes = (timeCounter % 3600) / 60;
        int seconds = timeCounter % 60;
        String prodtimeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        //productiveTimeLabel = new JLabel(prodtimeString);
        // add(productiveTimeLabel);
        //add(productiveTimeLabel);
        // Format the time as a string in the form "HH:MM:SS"
        //prodtimeLabel.add(prodtimeString)
        System.out.println("Total productive time:"+ prodtimeString);
        JOptionPane.showMessageDialog(null,prodtimeString);
       // return prodtimeString;
    }

    private void addBreak() {
        // Get the break duration from the text field
        String breakDurationString = breakDurationField.getText();
        int breakDuration = Integer.parseInt(breakDurationString)*60;

        // Adding the break duration to the counter and update the time label, as break reduces the productive time
        timeCounter -= breakDuration;
        updateTimeLabel();
    }

    private void updateTimeLabel() {
        // Calculate the number of hours, minutes, and seconds and add them to separate variables
        int hours = timeCounter / 3600;
        int minutes = (timeCounter % 3600) / 60;
        int seconds = timeCounter % 60;

        // Format the time as a string in the form "HH:MM:SS"
        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        // Set the text of the time label to the formatted time string
        timeLabel.setText(timeString);
    }

    private void reset(){
        //Reset the timer to 00:00:00
        timer.stop();
        timerRunning = false;
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        breakDurationField.setEnabled(false);
        addBreakButton.setEnabled(false);
        timeLabel.setText("00:00:00");
    }

    public static void main(String[] args) {
        new BITSProductiveTimeTracker();
    }
}
