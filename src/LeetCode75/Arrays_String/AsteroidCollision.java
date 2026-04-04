package LeetCode75.Arrays_String;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] ints = new AsteroidCollision().asteroidCollision(new int[]{-2,-2, -1, -2});
        Arrays.stream(ints).forEach(System.out::println);
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            if(stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            }else {
                while (!stack.isEmpty() && stack.peek() > 0 &&(stack.peek() < Math.abs(asteroids[i]))) {
                    stack.pop();
                }
                if(!stack.isEmpty() && ((-stack.peek() == asteroids[i]) || stack.peek() == -asteroids[i])) {
                    stack.pop();
                }
                if(stack.isEmpty() || (!stack.isEmpty() && stack.peek() < 0 && asteroids[i] < 0)) {
                    stack.push(asteroids[i]);
                }
            }
        }
        return stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
