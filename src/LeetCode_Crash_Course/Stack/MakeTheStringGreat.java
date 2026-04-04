package LeetCode_Crash_Course.Stack;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        String s = "Pp";
        System.out.println(new MakeTheStringGreat().makeGood(s));
    }
    public String makeGood(String s) {
        for(int i = 0; i < s.length()-1; i++) {
            if(Math.abs(s.charAt(i)-s.charAt(i+1)) == 32) {
                return makeGood(s.substring(0,i)+s.substring(i+2,s.length()));
            }
        }
        return s;
    }
}

