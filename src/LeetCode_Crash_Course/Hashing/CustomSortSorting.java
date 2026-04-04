package LeetCode_Crash_Course.Hashing;

public class CustomSortSorting {
    public static void main(String[] args) {
       String order = "cba", s = "abcd";
        System.out.println(customSortString(order,s));
    }
    public static String customSortString(String order, String s) {
        int [] count = new int[26];
        for(Character c : s.toCharArray()) {
            count[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : order.toCharArray()) {
            while(count[c-'a'] > 0) {
                sb.append(c);
                count[c-'a']--;
            }
        }
        for(char c = 'a'; c <= 'z'; c++) {
            while(count[c-'a'] > 0) {
                sb.append(c);
                count[c-'a']--;
            }
        }
        return sb.toString();
    }
}
