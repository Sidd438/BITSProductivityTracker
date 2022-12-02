import org.joda.time.DateTime;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ManipulateTime implements Runnable{

    private final static int NUMBER_OF_MILLISECONDS_IN_A_SECOND = 1000;
    private Date myStartTimeDate;
    private Integer myBreakMinutes;
    private JLabel elapsedTimeLabel;

    public Date getMyStartTimeDate() {
        return myStartTimeDate;
    }

    public void setMyStartTimeDate(Date myStartTimeDate) {
        this.myStartTimeDate = myStartTimeDate;
    }

    public Integer getMyBreakMinutes() {
        return myBreakMinutes;
    }

    public void setMyBreakMinutes(Integer myBreakMinutes) {
        this.myBreakMinutes = myBreakMinutes;
    }

    public JLabel getElapsedTimeLabel() {
        return elapsedTimeLabel;
    }

    public void setElapsedTimeLabel(JLabel elapsedTimeLabel) {
        this.elapsedTimeLabel = elapsedTimeLabel;
    }
    public void run(){
        while(true){
            calcTimeWorked();
            try{
                Thread.sleep(10*NUMBER_OF_MILLISECONDS_IN_A_SECOND);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void calcTimeWorked(){
        System.out.println("Start time: "+ myStartTimeDate);

        DateTime timeNow = new DateTime();
        DateTime startTime = new DateTime(myStartTimeDate);

        //add break minutes to start time
        System.out.println("Adding minutes to start:" + startTime);
        startTime = startTime.plusMinutes(myBreakMinutes);

        org.joda.time.Period period = new org.joda.time.Period(startTime, timeNow);
        try{
            try {
                PeriodFormatter periodFormatter = new PeriodFormatterBuilder().appendDays().appendSuffix(" days").appendHours().appendSuffix(" hours").appendMinutes().appendSuffix(" minutes").appendSeconds().appendSuffix(" seconds").toFormatter();
                String elapsed = periodFormatter.print(period);


                elapsedTimeLabel.setText(elapsed);

                if (period.getHours() >=8){
                    elapsedTimeLabel.setForeground(Color.GREEN);
                } else {
                    elapsedTimeLabel.setForeground(Color.RED);
                }

            } catch ( Exception e){
                e.printStackTrace();
            }
            } catch (Exception e){
            e.printStackTrace();
        }


    }
}
