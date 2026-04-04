Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false


solution::

class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int len1 = s1.size();
        int len2 = s2.size();
        int len3 = s3.size();
        if(len1 + len2 != len3) {
            return false;
        }
        vector<vector<int>>dp(len1+1, vector<int>(len2+1, 0));
        for(int i = 0; i <= len1; i++) {
            for(int j = 0; j <= len2; j++) {
                if(i ==0 && j == 0) {
                    dp[i][j] = 1;
                }else if(i == 0) {
                    if(s3[j-1] == s2[j-1]) {
                        dp[i][j] = dp[i][j-1];
                    }
                }else if(j == 0) {
                    if(s3[i-1] == s1[i-1]) {
                        dp[i][j] = dp[i-1][j];
                    }
                }else {
                    if(s3[i+j-1] == s1[i-1] && s3[i+j-1] != s2[j-1]) {
                        dp[i][j] = dp[i-1][j];
                    }else if(s3[i+j-1] != s1[i-1] && s3[i+j-1] == s2[j-1]) {
                        dp[i][j] = dp[i][j-1];
                    }else if(s3[i+j-1] == s1[i-1] && s3[i+j-1] == s2[j-1]) {
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }
                }
            }
        }
        return dp[len1][len2];
    }
};
