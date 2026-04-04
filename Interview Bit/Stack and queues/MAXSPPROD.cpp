Problem Description

You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] and (i>j). If multiple A[j]'s are present in multiple positions, the LeftSpecialValue is the maximum value of j.
RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] and (j>i). If multiple A[j]'s are present in multiple positions, the RightSpecialValue is the minimum value of j.
Write a program to find the maximum special product of any integer in the array.

NOTE: As the answer can be large, output your answer modulo 109 + 7.



Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the maximum special product of any integer.



Example Input
Input 1:

 A = [1, 4, 3, 4]
Input 2:

 A = [10, 7, 100]


Example Output
Output 1:

 3
Output 2:

 0


Example Explanation
Explanation 1:

 For A[2] = 3, LeftSpecialValue is 1 and RightSpecialValue is 3.
 So, the ans is 1*3 = 3.

Explanation 2:

 There is not any integer having maximum special product > 0. So, the ans is 0.




 *****solution::


int Solution::maxSpecialProduct(vector<int> &A) {
    long int left_value = 0;
    long int right_value = 0;
    int start = 0;
    int end = 0;
    long int msp = INT_MIN;
    bool flag = false;
    int i,n;
    n = A.size();
    if(n < 2) {
        return 0;
    }
    for(end = 1; end < n-1; end++) {
        if(A[start] > A[end]) {
            left_value = start;
            flag = true;
        }
        if(A[end-1] > A[end]) {
            start = end-1;
            left_value = start;
            flag = true;
        }
        if(A[end] < A[end+1]) {
            right_value = end+1;
        }
        if(flag == false) {
            start = start+1;
        }
        if((left_value * right_value) > msp) {
            msp = left_value * right_value;
        }
        left_value = 0;
        right_value = 0;
        flag = false;
    }
    return (int)(msp%1000000007);
}

