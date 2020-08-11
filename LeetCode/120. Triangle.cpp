Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


solution::

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {

        int n = triangle.size();
        if(n == 1) {
            return triangle[0][0];
        }
        int sum = INT_MAX;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < triangle[i].size(); j++) {
                if(j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                }else if(j == triangle[i].size()-1) {
                    triangle[i][j] += triangle[i-1][j-1];
                }else {
                    triangle[i][j]+= min(triangle[i-1][j-1], triangle[i-1][j]);
                }

                if(i == n-1) {
                    sum = min(sum, triangle[i][j]);
                }
            }
        }
        return sum;
    }

};
