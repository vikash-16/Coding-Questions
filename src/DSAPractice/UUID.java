package DSAPractice;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class UUID {
    public static void main(String[] args) {
        System.out.println((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);
        int []jobs = {5,2,4}, workers = {1,7,5};
        System.out.println(new UUID().minimumTime(jobs,workers));
    }
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < jobs.length; i++) {
            res = Math.max(res,(int) Math.ceil((double) jobs[i]/workers[i]));
        }
        return res;
    }
}
