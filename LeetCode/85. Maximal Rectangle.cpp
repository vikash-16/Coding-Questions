Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6

solution::

class Solution {
public:
    int LargestRectangleArea(vector<int>A) {
        int n = A.size();
        stack<int>s;
        int i = 0, top_val = 0, area = 0, maximum_area = 0;
        while(i < n) {
            if(s.empty() || A[s.top()] <= A[i]) {
                s.push(i++);
            }else {
                top_val = A[s.top()];
                s.pop();
                area = top_val* i;
                if(!s.empty()) {
                    area = top_val*(i-s.top()-1);
                }
                maximum_area = max(maximum_area, area);
            }
        }
        while(!s.empty()) {
            top_val = A[s.top()];
            s.pop();
            area = top_val*i;
            if(!s.empty()) {
                area = top_val * (i-s.top()-1);
            }
            maximum_area = max(maximum_area, area);
        }
        return maximum_area;
    }
    int maximalRectangle(vector<vector<char>>& matrix) {
        long int curr_area = 0;
        long int max_area = 0;
        int row = matrix.size();
         if(row == 0) {
            return 0;
        }
        int col = matrix[0].size();

        vector<vector<int>>dp(row, vector<int>(col));
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }else if(matrix[i][j] == '1'){
                    dp[i][j] = 1;
                }
            }
        }
        for(int i = 1; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(dp[i][j] == 1) {
                    dp[i][j] += dp[i-1][j];
                }
            }
        }
        for(int i = 0; i < row; i++) {
            curr_area = LargestRectangleArea(dp[i]);
            max_area = max(max_area, curr_area);
        }
        return max_area;
    }
};
