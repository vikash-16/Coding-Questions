package LeetCode75.Arrays_String;

import java.util.*;

public class RecentCounter {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(1);
    }
    Queue<Integer>queue = new LinkedList<>();
    public RecentCounter() {

    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t-3000) {
            queue.poll();
        }
        return queue.size();
    }
}
