package LeetCode_Crash_Course.Stack;

public class RemovingStarsFromaString {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(new RemovingStarsFromaString().removeStars(s));
    }
    public String removeStars(String s) {
        /*ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && c == '*') {
                stack.removeLast();
            }else {
                stack.addLast(c);
            }
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.removeFirst());
        }
        return str.toString();*/
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '*') {
                str.deleteCharAt(str.length()-1);
            }
            else {
                str.append(c);
            }
        }
        return str.toString();
    }
}
