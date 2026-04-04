package DSAPractice.Strings;

public class RepeatedSubStringPattern {
    public static void main(String[] args) {
        System.out.println(new RepeatedSubStringPattern().repeatedSubstringPattern("abab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String substring = s.substring(0, i);
            if(s.length() % i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(substring.repeat(s.length() / i));
                if (stringBuilder.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
