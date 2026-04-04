package LeetCode_Crash_Course.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class validateStackSequence {
    public static void main(String[] args) {
       int [] pushed = {1,2,3,4,5}, popped = {4,3,5,1,2};
        System.out.println(new validateStackSequence().validateStackSequences(pushed,popped));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer>deque = new ArrayDeque<>();
        int i = 0,j = 0;
        while(i < pushed.length) {
            deque.addLast(pushed[i]);
            while(!deque.isEmpty() && deque.peekLast() == popped[j]) {
                deque.removeLast();
                j++;
            }
            i++;
        }
        while(!deque.isEmpty()) {
            if(deque.peekLast() != popped[j]) {
                return false;
            }else {
                deque.removeLast();
                j++;
            }
        }
        return true;
    }
}
