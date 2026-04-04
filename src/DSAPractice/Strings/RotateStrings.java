package DSAPractice.Strings;

public class RotateStrings {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(new RotateStrings().rotateString(s,goal));
    }
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int length = s.length();
        int i = 1;
        while (i < s.length()) {
            StringBuilder str = new StringBuilder();
            str.append(s.substring(i));
            str.append(s.substring(0,i));
            i++;
            if(str.toString().equalsIgnoreCase(goal)) {
                return true;
            }
        }
        return false;
    }
}
