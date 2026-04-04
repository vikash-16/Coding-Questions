package DSAPractice.Strings;

public class StrStr {
    public static void main(String[] args) {
        System.out.println(strstr("geeksforgeeks","for"));
    }
    static int strstr(String haystack, String needle)
    {
        if(haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }else {
            return -1;
        }
    }
}
