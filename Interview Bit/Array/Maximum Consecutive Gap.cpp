Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.

*****solution:

int Solution::maximumGap(const vector<int> &A) {
    vector<int>B = A;
    int curr_diff = 0;
    int max_diff = INT_MIN;
    int i,n;
    n = A.size();
    if(n < 2) {
        return 0;
    }
    sort(B.begin(),B.end());
    for(i = 0; i < n-1; i++) {
        curr_diff = B[i+1]-B[i];
        max_diff = max(max_diff,curr_diff);
    }
    return max_diff;
}

