Given an array of integers A of size N. A represents a histogram i.e A[i] denotes height of
the ith histogram’s bar. Width of each bar is 1.

Largest Rectangle in Histogram: Example 1

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Largest Rectangle in Histogram: Example 2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Find the area of largest rectangle in the histogram.



Input Format

The only argument given is the integer array A.
Output Format

Return the area of largest rectangle in the histogram.
For Example

Input 1:
    A = [2, 1, 5, 6, 2, 3]
Output 1:
    10
    Explanation 1:
        The largest rectangle is shown in the shaded area, which has area = 10 unit.






*********solution::



int Solution::largestRectangleArea(vector<int> &A) {
    int n = A.size();
    stack<int>s;
    int i = 0;
    int tval = 0;
    int area,max_area = 0;
    while(i < n) {
        if(s.empty() || A[s.top()] <= A[i]) {
            s.push(i++);
        } else {
            tval = A[s.top()];
            s.pop();
            area = tval*i;
            if(!s.empty()) {
                area = tval*(i-s.top()-1);
            }
            max_area = max(max_area, area);
        }
    }
    while(!s.empty()) {
        tval = A[s.top()];
        s.pop();
        area = tval*i;
        if(!s.empty()) {
            area = tval*(i-s.top()-1);
        }
        max_area = max(max_area, area);
    }
    return max_area;
}

