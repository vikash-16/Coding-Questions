package DSAPractice.Stack;

import java.util.Stack;

public class RemoveOuterParanTheses {
    public static void main(String[] args) {
        String s ="(()())(())(()(()))";
        System.out.println(new RemoveOuterParanTheses().removeOuterParentheses(s));
    }
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int opened = 0;
        for(char c : s.toCharArray()) {
            if(c == ')') opened--;
            if(opened > 0) str.append(c);
            if(c == '(') opened++;
        }
        return str.toString();
    }
}
