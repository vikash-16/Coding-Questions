package LeetCode_Crash_Course.Stack;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Stack;

public class MinStack {
    Stack<Map.Entry>st = new Stack<>();
    int minimum = Integer.MAX_VALUE;
    public static void main(String[] args) {
        new MinStack().push(1);
    }
    public MinStack() {

    }

    public void push(int val) {
        if(st.isEmpty()) {
            st.push(new SimpleEntry(val,val));
            minimum = val;
        }else {
            Map.Entry peek = st.peek();
            minimum = Math.min(minimum, (int) peek.getKey());
            st.add(new SimpleEntry(val,minimum));
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return (int)st.peek().getKey();
    }

    public int getMin() {
        return (int)st.peek().getValue();
    }
}
