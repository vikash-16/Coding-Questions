package DSAPractice.Stack;

import java.util.Stack;

public class ImplementQueueUsingStack {
    public static void main(String[] args) {

    }
    Stack<Integer>s1 = new Stack<>();
    Stack<Integer>s2 = new Stack<>();
    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(s1.empty()) {
            return 0;
        }
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        Integer pop = s2.pop();
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return pop;
    }

    public int peek() {
        if(s1.empty()) {
            return 0;
        }
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        Integer peek = s2.peek();
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return peek;
    }

    public boolean empty() {
        return s1.empty();
    }
}
