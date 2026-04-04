You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.

***solution:

vector<int> Solution::subUnsort(vector<int> &A) {
    int n = A.size();
    int i,j;
    int start = -1;
    int end = -1;
    int minimum = 0;
    int maximum = 0;
    int flag = 0;
    vector<int>res;
    for(i = 0; i < n-1; i++) {
        if(A[i] > A[i+1]) {
            start = i;
            break;
        }
    }
    for(j = n-1; j > 0; j--) {
        if(A[j-1] > A[j]) {
            end = j;
            break;
        }
    }
    minimum = A[start];
    maximum = A[start];
    for(int i = start+1; i <= end; i++) {
        if(A[i] < minimum) {
            minimum = A[i];
        }
        if(A[i] > maximum) {
            maximum = A[i];
        }
    }
    for(int i = 0; i < start; i++) {
        if(A[i] > minimum) {
            start = i;
            break;
        }
    }
    for(int j = n-1; j > end; j--) {
        if(A[j] < maximum) {
            end = j;
            break;
        }
    }
    if(start == -1 && end == -1) {
        res.push_back(-1);
    } else {
        res.push_back(start);
        res.push_back(end);
    }
    return res;

}

