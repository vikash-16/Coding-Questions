Problem Description

Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the maximum value of j - i;



Example Input
Input 1:

 A = [3, 5, 4, 2]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

 Maximum value occurs for pair (3, 4).

 ****solution:

int Solution::maximumGap(const vector<int> &A) {
    int j,i;
    j = A.size()-1;
    int max_dist = 0;
    int min_val = INT_MAX;
    int max_val = INT_MIN;
    vector<int>left_min(A.size());
    vector<int>right_max(A.size());
    left_min[0] = A[0];
    for(int i = 1; i < A.size(); i++) {
        left_min[i] = min(A[i],left_min[i-1]);
        }
    right_max[A.size()-1] = A[A.size()-1];
    for(int i = A.size()-2; i >= 0; i--) {
        right_max[i] = max(A[i],right_max[i+1]);
    }
    i = 0;
    j = 0;
    while(i < A.size() && j < A.size()) {
        if(left_min[i] <= right_max[j]) {
            max_dist = max(max_dist,j-i);
            j++;
        } else {
            i++;
        }
    }
    return max_dist;
}

