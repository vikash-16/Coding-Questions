You are given an array A consisting of strings made up of the letters �a� and �b� only.
Each string goes through a number of operations, where:

1.	At time 1, you circularly rotate each string by 1 letter.
2.	At time 2, you circularly rotate the new rotated strings by 2 letters.
3.	At time 3, you circularly rotate the new rotated strings by 3 letters.
4.	At time i, you circularly rotate the new rotated strings by i % length(string) letters.

Eg: String is "abaa"

1.	At time 1, string is "baaa", as 1 letter is circularly rotated to the back
2.	At time 2, string is "aaba", as 2 letters of the string "baaa" is circularly rotated to the back
3.	At time 3, string is "aaab", as 3 letters of the string "aaba" is circularly rotated to the back
4.	At time 4, string is again "aaab", as 4 letters of the string "aaab" is circularly rotated to the back
5.	At time 5, string is "aaba", as 1 letters of the string "aaab" is circularly rotated to the back
After some units of time, a string becomes equal to it�s original self.
Once a string becomes equal to itself, it�s letters start to rotate from the first letter again (process resets). So, if a string takes t time to get back to the original, at time t+1 one letter will be rotated and the string will be it�s original self at 2t time.
You have to find the minimum time, where maximum number of strings are equal to their original self.
As this time can be very large, give the answer modulo 109+7.

Note: Your solution will run on multiple test cases so do clear global variables after using them.

Input:

A: Array of strings.
Output:

Minimum time, where maximum number of strings are equal to their original self.
Constraints:

1 <= size(A) <= 10^5
1 <= size of each string in A <= 10^5
Each string consists of only characters 'a' and 'b'
Summation of length of all strings <= 10^7
Example:

Input

A: [a,ababa,aba]
Output

4

String 'a' is it's original self at time 1, 2, 3 and 4.
String 'ababa' is it's original self only at time 4. (ababa => babaa => baaba => babaa => ababa)
String 'aba' is it's original self at time 2 and 4. (aba => baa => aba)

Hence, 3 strings are their original self at time 4.




*******solution::



/*#define mod 1000000007;
int Solution::solve(vector<string> &A) {
    string temp = "";
    char c;
    int count = 0;
    int max_count = 0;
    for(int i = 0; i < A.size(); i++) {
        temp = A[i];
        count = 0;
        while(true) {
            c = temp[0];
            temp.erase(temp.begin());
            temp.push_back(c);
            count++;
            if(temp == A[i]){
                break;
            }
            max_count = max(count,max_count);
        }
    }
    return max_count%mod;
}
*/
#define mod 1000000007
int Solution::solve(vector<string>&A) {
    int l = 1,len=A.size(),h;
    vector<int>v(len);
    for(int k=0;k<len;k++){
        //  saving time interval t for each string
    int n = A[k].length();
    if(n<=1){
       v[k] = 1;
    }
    else{
        long long i=1,changes=0;
        string s = A[k];
        while(1){
            changes = (i*(i+1))/2;
          if(changes%n==0){
              v[k]=i;
              break;
          }
            i++;
        }
     }

    }
    long long ans=1;
    for(int i=0;i<len;i++){
        for(int j=i+1;j<len && v[i]!=1 ;j++){

            v[j] = v[j]/__gcd(v[j],v[i]);
        }
        ans = 1ll*(ans%mod*(v[i])%mod)%mod;
    }
 return ans%mod;
}
