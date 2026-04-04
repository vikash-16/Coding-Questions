Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.




Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].




The largest rectangle is shown in the shaded area, which has area = 10 unit.



Example:

Input: [2,1,5,6,2,3]
Output: 10


solution::

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        stack<int>s;
        int i = 0;
       long int tval = 0;
        long int area,max_area = 0;
        while(i < n) {
            if(s.empty() || heights[s.top()] <= heights[i]) {
                s.push(i++);
            } else {
                tval = heights[s.top()];
                s.pop();
                area = tval*i;
                if(!s.empty()) {
                    area = tval*(i-s.top()-1);
                }
                max_area = max(max_area, area);
            }
        }
        while(!s.empty()) {
            tval = heights[s.top()];
            s.pop();
            area = tval*i;
            if(!s.empty()) {
                area = tval*(i-s.top()-1);
            }
            max_area = max(max_area, area);
        }
        return max_area;
    }
};
