package DSAPractice.Arrays;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Stack<Character>st = new Stack<Character>();
        if(s.length()%2 != 0) return false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }else if(!st.isEmpty()) {
                if(st.peek() == '(' && s.charAt(i) == ')') {
                    st.pop();
                }else if(st.peek() == '{' && s.charAt(i) == '}') {
                    st.pop();
                }else if(st.peek() == '[' && s.charAt(i) == ']') {
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
