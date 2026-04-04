Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers.

Assume that there will only be one solution

Example:
given array S = {-1 2 1 -4},
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)


******solution::


int Solution::threeSumClosest(vector<int> &A, int B) {
    long long int i,j,k,res = (long long)B;
    long long sum;
    long long diff = INT_MAX;
    sort(A.begin(),A.end());
    for(i = 0;i < A.size()-2; i++) {
        j = i+1;
        k = A.size()-1;
        while(j < k) {
            sum = A[i]+A[j]+A[k];
            if(abs(B-sum) < diff) {
                diff = abs(B-sum);
                res = sum;
            }else if(sum > B) {
                k--;
            }else{
                j++;
            }
        }
    }
    return res;
}

