Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.


******solution:

int Solution::firstMissingPositive(vector<int> &A) {
    vector<bool>res(A.size()+1,false);
    for(int i = 0; i < A.size();i++) {
        if(A[i]>0 && A[i] <= A.size()) {
            res[A[i]] = true;
        }
    }
    for(auto it = 1; it <= res.size(); it++) {
        if(res[it] == false) {
            return it;
        }
    }
    return 1;
}

