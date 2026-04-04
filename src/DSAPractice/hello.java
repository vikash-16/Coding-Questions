package DSAPractice;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.*;


public class hello {
        static int t;
        hello()
        {
            System.out.print ("C ");
            t = 99;
        }
        static
        {
            t = 100;
            System.out.print ("S ");
            System.out.print (t + " ");
        }
        public void func()
        {
            t++;
            System.out.print (t + " ");
        }

        public static void main(String[] args) {
            hello hello = new hello();
            hello.func();
        }
    public static Date stringToDate(String time,String format) {
//        String format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            formatter.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
            return formatter.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}