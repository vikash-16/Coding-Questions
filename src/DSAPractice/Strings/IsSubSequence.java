package DSAPractice.Strings;

public class IsSubSequence {
    public static void main(String[] args) {
        String str1 = "axc", str2 = "ahbgd";
        System.out.println(isSubSequence(str1,str2));
    }

    private static boolean isSubSequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }
        if(t.length() == 0) {
            return false;
        }
        int i = 0;
        for(int j = 0; j < t.length(); j++) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            if(i == s.length()) {
                return true;
            }
        }
        return false;
    }
}
