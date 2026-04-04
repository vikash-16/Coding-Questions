package DSAPractice.Strings;

public class FirstIndexOfOccurance {
    public static void main(String[] args) {
        System.out.println(new FirstIndexOfOccurance().strStr("sadbutsad","sad"));
    }
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) {
            return -1;
        }
        for(int i = 0; i < haystack.length()-needle.length()+1; i++) {
            String substring = haystack.substring(i, i + needle.length());
            if(substring.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
