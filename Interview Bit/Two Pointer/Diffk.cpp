Given an array �A� of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example: Input :
    A : [1 3 5]
    k : 4
 Output : YES as 5 - 1 = 4
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.


***solution::


int Solution::diffPossible(vector<int> &A, int B) {
    for(int i = 0; i < A.size(); i++) {
        for(int j = i+1; j< A.size();j++) {
            if(A[j]-A[i] == B) {
                return 1;
            }
        }
    }
    return 0;
}

