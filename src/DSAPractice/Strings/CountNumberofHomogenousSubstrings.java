package DSAPractice.Strings;

public class CountNumberofHomogenousSubstrings {
    public static void main(String[] args) {
        String  s = "abbcccaa";
        System.out.println(new CountNumberofHomogenousSubstrings().countHomogenous(s));

    }
    public int countHomogenous(String s) {
        int mod = 1000000007;
        int totalCount = 0;
        int count = 0;
       for(int i = 0; i < s.length(); i++) {
           if(i == 0 || s.charAt(i) == s.charAt(i-1)) {
               count++;
           }else {
               count = 1;
           }
           totalCount = (totalCount+count)%mod;
       }
       return totalCount;
    }
}
