package DSAPractice.Strings;

public class HasSpecialSubstring {
    public static void main(String[] args) {
        System.out.println(hasSpecialSubstring("ii",1));
    }
    public static boolean hasSpecialSubstring(String s, int k) {
        int i = 0, j = 1,count = 1;
        if(s.length() ==1 ) return true;
        while(j < s.length()) {
            while (j < s.length() && s.charAt(j) == s.charAt(j-1)) {
                count++;;
                j++;
            }
            if(j < s.length() && s.charAt(j) != s.charAt(j-1)) {
                if (count == k) {
                    return true;
                }else{
                    count = 1;
                    j++;
                }
            }
        }
        if(count == k) return true;
        return false;
    }
}
