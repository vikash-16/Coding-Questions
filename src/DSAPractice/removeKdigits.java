package DSAPractice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class removeKdigits {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        // Generate a random number of days within one month (30 days)
        Random random = new Random();
        int daysToAdd = random.nextInt(30);

        // Add the random number of days to the current date
        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);

        // Get the generated date
        Date randomDate = calendar.getTime();

        System.out.println("Generated Random Date: " + randomDate);
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().minusDays(15).with(LocalTime.MIN));
        System.out.println(LocalDateTime.now().minusDays(30).with(LocalTime.MIN));

    }
}
