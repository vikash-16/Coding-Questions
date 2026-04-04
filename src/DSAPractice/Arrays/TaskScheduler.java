package DSAPractice.Arrays;

import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {
        char [] task = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(new TaskScheduler().leastInterval(task,n));
    }
    public int leastInterval(char[] tasks, int n) {
        int[] charOccurrence = new int[26];
        for (char c : tasks) {
            charOccurrence[c - 'A']++;
        }
        Arrays.sort(charOccurrence);
        int max = charOccurrence[25];
        int slots = (max - 1) * n;
        for (int i = 24; i >= 0 && slots > 0; i--) {
            slots -= Math.min(max - 1, charOccurrence[i]);
        }
        slots = Math.max(0, slots);
        return slots + tasks.length;
    }
}
