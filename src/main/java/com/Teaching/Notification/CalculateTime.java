package com.Teaching.Notification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalculateTime {

    public static String findDifference(String start_date, String end_date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        // Try Class
        try {

            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);

            System.out.println("start "+start_date+"     end "+end_date);
            long difference_In_Time = d2.getTime() - d1.getTime();

            long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;

            long difference_In_Minutes = TimeUnit .MILLISECONDS.toMinutes(difference_In_Time) % 60;

            long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time)% 24;

            long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time)% 365;

            long difference_In_Years = TimeUnit.MILLISECONDS.toDays(difference_In_Time)/ 365l;

            System.out.println(difference_In_Years+" year "+difference_In_Days+" days "
                    +difference_In_Hours+" hours "+difference_In_Minutes+" min "
                    +difference_In_Seconds+" second");

            if(difference_In_Years == 0 && difference_In_Days == 0 && difference_In_Hours == 0 && difference_In_Minutes == 0 && difference_In_Seconds!=0)
                return "now";
            else if(difference_In_Years == 0 && difference_In_Days == 0 && difference_In_Hours == 0)
                return difference_In_Minutes+" min";
            else if(difference_In_Years == 0 && difference_In_Days == 0)
                return difference_In_Hours +" hours";
            else {
                return new SimpleDateFormat("dd-MMM-yyyy").format(d1);
            }
        } catch (ParseException e) {
            return null;
        }
    }
}
