Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"


solution::


class Solution {
public:
    int longestValidParentheses(string s) {
        int n = s.size();
        if(n == 0 || n == 1) {
            return 0;
        }
        stack<int>st;
        st.push(-1);
        int len = 0;
        int max_len = 0;
        for(int i = 0; i < n; i++) {
            if(s[i] == '(' ) {
                st.push(i);
            }else {
                st.pop();
                if(st.empty()) {
                    st.push(i);
                }else {
                    len = i - st.top();
                    max_len = max(len, max_len);
                }
            }
        }
        return max_len;
    }
};
