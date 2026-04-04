package DSAPractice.Strings;

public class LongestPalindromeString {
    public static void main(String[] args) {
        String s = "aaaabbaa";
        System.out.println(longestPalin(s));
    }
    static String longestPalin(String s){
        int length = s.length();
        Boolean dp[][] = new Boolean[length][length];
        int maxLength = 1;
        for(int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        for(int i = 0; i < length-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        for(int len = 3; len <= length; len++) {
            for(int i = 0; i < length-len+1; i++) {
                int j = i+len-1;
                if(dp[i+1][j-1] != null && dp[i+1][j-1] == true && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if(len > maxLength) {
                        maxLength = len;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);
    }
}
