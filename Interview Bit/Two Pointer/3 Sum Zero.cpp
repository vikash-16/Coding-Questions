Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2)



*****solution::


vector<vector<int> > Solution::threeSum(vector<int> &A) {
    vector<vector<int>>res;
    set<vector<int>>s;
    vector<int>temp;
    long long int i,left,right,sum;
    int n = A.size();
    sort(A.begin(),A.end());
    for(i = 0; i < n-2; i++) {
        left = i+1;
        right = n-1;

        while(left < right) {
            sum = ((long long)A[i] + (long long )A[left] + (long long)A[right]);
            if(sum == 0) {
                temp.push_back(A[i]);
                temp.push_back(A[left]);
                temp.push_back(A[right]);
                if(s.find(temp) == s.end()) {
                    res.push_back(temp);
                    s.insert(temp);
                }
                temp.clear();
                left++;

            }else if(sum > 0) {
                right--;
            }else {
                left++;
            }

        }
    }

    return res;
}

