package LeetCode75.Arrays_String;

import java.util.Stack;

public class RemoveStars {
    public static void main(String[] args) {
        String string = new RemoveStars().removeStars("erase*****");
        System.out.println(string);
    }
    public String removeStars(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character>st = new Stack<>();
        for(char c: charArray) {
            if(c == '*' && !st.empty()) {
                st.pop();
            }else {
                st.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!st.empty()) {
            stringBuilder.append(st.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
