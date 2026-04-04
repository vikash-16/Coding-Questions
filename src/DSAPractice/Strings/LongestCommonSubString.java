package DSAPractice.Strings;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "abcdef", s2 = "defabd";
        System.out.println(new LongestCommonSubString().longestCommonSubString(s1,s2));
    }

    private String longestCommonSubString(String s1, String s2) {
        return lcshelper(s1,s2,0,0,0,"");
    }

    private String lcshelper(String s1, String s2, int i, int j, int count, String substr) {
        if(i == s1.length() || j == s2.length()) {
            return count > 0 ? substr : null;
        }
        if(s1.charAt(i) == s2.charAt(j)) {
            lcshelper(s1,s2,i+1,j+1,count+1,substr+s1.charAt(i));
        }else {
            lcshelper(s1,s2,i+1,j,count,substr);
            lcshelper(s1,s2,i,j+1,count,substr);
        }
        return null;
    }


}
