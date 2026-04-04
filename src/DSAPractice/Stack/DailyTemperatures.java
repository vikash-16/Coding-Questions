package DSAPractice.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class DailyTemperatures {
    public static void main(String[] args) {
        int [] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(temperatures)));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        ArrayDeque<Integer>stack = new ArrayDeque<>();
        int [] result = new int[n];
        result[n-1] = 0;
        stack.push(n-1);
        for(int i = n-2; i>= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if(!stack.isEmpty() && temperatures[i] < temperatures[stack.peek()]) {
                result[i] = Math.abs(i-stack.peek());
            }else {
                result[i] = 0;
            }
            stack.push(i);
        }
        return result;
    }
}
