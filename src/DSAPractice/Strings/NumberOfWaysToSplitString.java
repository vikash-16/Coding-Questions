package DSAPractice.Strings;

/*
*Given a binary string s, you can split s into 3 non-empty strings s1, s2, and s3 where s1 + s2 + s3 = s.

Return the number of ways s can be split such that the number of ones is the same in s1, s2, and s3. Since the answer may be too large, return it modulo 109 + 7.



Example 1:

Input: s = "10101"
Output: 4
Explanation: There are four ways to split s in 3 parts where each part contain the same number of letters '1'.
"1|010|1"
"1|01|01"
"10|10|1"
"10|1|01"
*
* */
public class NumberOfWaysToSplitString {
    public static void main(String[] args) {
        String s = "10101";
        System.out.println(numWays(s));
    }
    public static int numWays(String s) {
        long n = s.length();
        long mod = 1000000007;
        long ones = 0;
        for(char c: s.toCharArray()) {
            ones+=c-'0';
        }
        if(ones == 0) {
            return (int)((((n-1)*(n-2))/2)%mod);
        }
        if(ones%3 != 0) {
            return 0;
        }
        long oneThird = ones/3;
        ones = 0;
        long ways1 = 0;
        long ways2 = 0;
        for(char c: s.toCharArray()) {
            ones+=c-'0';
            if(ones == oneThird) ways1++;
            if(ones == 2*oneThird) ways2++;
        }

        return (int)((ways1*ways2)%mod);
    }
}
