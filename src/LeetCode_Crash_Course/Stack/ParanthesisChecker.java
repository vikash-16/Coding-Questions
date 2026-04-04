package LeetCode_Crash_Course.Stack;

import java.util.Stack;

public class ParanthesisChecker {
    public static void main(String[] args) {
        String s = "[)]{}{[()()]()}";
        System.out.println(ispar(s));
    }
    static boolean ispar(String x)
    {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < x.length(); i++) {
            if(x.charAt(i) == '[' || x.charAt(i) == '{' || x.charAt(i) == '(') {
                st.push(x.charAt(i));
            }else if(!st.isEmpty()) {
                if(st.peek() == '[' && x.charAt(i) == ']') {
                    st.pop();
                }else if(st.peek() == '{' && x.charAt(i) == '}') {
                    st.pop();
                }else if(st.peek() == '(' && x.charAt(i) == ')') {
                    st.pop();
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return st.isEmpty();
    }
}
