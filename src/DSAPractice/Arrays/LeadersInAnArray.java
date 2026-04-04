package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.Stack;

public class LeadersInAnArray {
    public static void main(String[] args) {
        int arr[] = {16,17,4,3,5,2};
        ArrayList<Integer> leaders = leaders(arr, arr.length);
        for(int i = 0; i < leaders.size(); i++) {
            System.out.println(leaders.get(i));
        }
    }
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n-1]);
        for(int i = n-2; i >= 0; i--) {
            if(arr[i] >= stack.peek()) {
                stack.push(arr[i]);
            }
        }
        while(!stack.isEmpty()) {
            result.add(stack.peek());
            stack.pop();
        }
        return result;
    }
}
