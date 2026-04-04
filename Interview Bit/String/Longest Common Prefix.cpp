Given the array of strings A,
you need to find the longest string S which is the prefix of ALL the strings in the array.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1
and S2.

For Example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Input Format

The only argument given is an array of strings A.
Output Format

Return longest common prefix of all strings in A.
For Example

Input 1:
    A = ["abcdefgh", "aefghijk", "abcefgh"]
Output 1:
    "a"
    Explanation 1:
        Longest common prefix of all the strings is "a".

Input 2:
    A = ["abab", "ab", "abcd"];
Output 2:
    "ab"
    Explanation 2:
        Longest common prefix of all the strings is "ab".




*********solution::


string solution(string str1, string str2) {
    int i = 0;
    int j = 0;
    int len1 = str1.length()-1;
    int len2 = str2.length()-1;
    string result;
    while(i <= len1 && j <= len2) {
        if(str1[i] != str2[j]) {
            break;
        } else {
            result.push_back(str1[i]);
            i++;
            j++;
        }
    }
    return result;
}
string DAC(vector<string>&A,int low,int high) {
    string str1;
    string str2;
    if(low == high) {
        return A[low];
    }
    int mid = (low + (high - low)/2);
    if(low < high) {
        str1 = DAC(A,low,mid);
        str2 = DAC(A,mid+1,high);
        return solution(str1,str2);
    }


}
string Solution::longestCommonPrefix(vector<string> &A) {
    int n = A.size();
    string res = DAC(A,0,n-1);
    return res;
}

