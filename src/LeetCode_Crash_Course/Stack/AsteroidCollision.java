package LeetCode_Crash_Course.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println(new AsteroidCollision().asteroidCollision(new int[]{5, 10, -5}));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int ele : asteroids) {
            if (dq.isEmpty() || ele > 0) {
                dq.addLast(ele);
            } else {
                while (!dq.isEmpty() && dq.peekLast() > 0 && Math.abs(dq.peekLast()) < Math.abs(ele)) {
                    dq.removeLast();
                }
                if(!dq.isEmpty() && (-dq.peekLast() == ele || dq.peekLast() == -ele)) {
                    dq.removeLast();
                } else if(dq.isEmpty() || (!dq.isEmpty() && ele < 0 && dq.peekLast() < 0)) {
                    dq.addLast(ele);
                }
            }
        }
        return dq.stream().filter(integer -> integer != null).mapToInt(i -> i).toArray();
    }
}
