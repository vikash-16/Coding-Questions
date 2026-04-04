Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Example 1:

Input: s1 = "great", s2 = "rgeat"
Output: true
Example 2:

Input: s1 = "abcde", s2 = "caebd"
Output: false


solution::

class Solution {
public:
    unordered_map<string, bool>dp;
    bool isScramble(string s1, string s2) {
        int len1 = s1.size();
        int len2 = s2.size();
        if(len1 != len2) {
            return 0;
        }
        if(s1.compare(s2) == 0) {
            return true;
        }
        if(len1 <= 1) {
            return false;
        }
        string key = s1+" "+s2;
        if(dp.find(key) != dp.end()) {
            return dp[key];
        }
        bool flag = false;
        for(int i = 1; i < len1; i++) {
            bool cond1 = isScramble(s1.substr(0, i), s2.substr(len2-i, i))&&isScramble(s1.substr(i, len1-i), s2.substr(0, len2-i));
            bool cond2 = isScramble(s1.substr(0, i), s2.substr(0, i))&&isScramble(s1.substr(i, len1-i), s2.substr(i, len2-i));

            flag = cond1 || cond2;
            if(flag)
                break;
        }
        return dp[key] = flag;
    }
};



// class Solution {
// public:
//    unordered_map<string,bool>m;

//     bool solve(string s1,string s2){


//         if(s1.compare(s2)==0)return 1;
//        // else return 0;
//         if(s1.size()<=1)return 0;

//         string key=s1+" "+s2;
//         if(m.find(key)!=m.end())return m[key];

//         bool ans=0;
//         int n=s1.size();

//         for(int i=1;i<n;i++){

// bool temp=solve(s1.substr(0,i),s2.substr(n-i,i))&&solve(s1.substr(i,n-i),s2.substr(0,n-i));

// bool temp1=solve(s1.substr(0,i),s2.substr(0,i))&&solve(s1.substr(i,n-i),s2.substr(i,n-i));

//         ans=temp1||temp;
//         if(ans==1)break;

//         }

//         return m[key]=ans;



//     }


//     bool isScramble(string s1, string s2) {
//      //   n=s1.size();
//         if(s1.size()!=s2.size()||(s1.size()==0&&s2.size()==0))return 0;
//        // v.assign(s1.size(),vector<int>(s2.size(),-1));
//         return solve(s1,s2);



//     }
// };
