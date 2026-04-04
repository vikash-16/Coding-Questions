package LeetCode_Crash_Course.Stack;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer>s1,s2 = new Stack<>();
    int front;
    public QueueUsingStacks() {
//        s1 = s2 = new Stack<>();
    }
    public void push(int x) {
        if(s1.empty()) front = x;
        while(!s1.empty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        Integer pop = s1.pop();
        if(!s1.empty()) {
            front = s1.peek();
        }
        return pop;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return s1.empty();
    }

    public static void main(String[] args) {

    }
}
