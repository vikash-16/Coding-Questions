You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
Considering each array element Ai as the edge length of some line segment, count the number of triangles which you can form using these array values.

Notes:

You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn’t matter. Any triangle formed should have a positive area.

Return answer modulo 109 + 7.

For example,

A = [1, 1, 1, 2, 2]

Return: 4



*****solution::


#define mod 1000000007;
int Solution::nTriang(vector<int> &A) {
    sort(A.begin(),A.end());
    int i,j,k;
    int count = 0;

    int n = A.size();
    if(n<3)
        return 0;
    for(j = 1; j < n-1; j++) {
        k = j+1;
        i = 0;
        while(k < n && i < j) {
            if(A[i]+A[j] > A[k]){
                count += j-i;
                k++;
            }else {
                i++;
            }
        }
    }
    return count % mod;
    /*int i,j,k,n = A.size(),cnt=0;
    sort(A.begin(),A.end());
    if(n<3) return 0;
    for(i = 0;i<n-2;i++){
        k = i+2;
        for(j=i+1;j<n-1;j++){
            while(k<n && A[i] + A[j] > A[k]) k++;
            if(k>j) cnt += k-j-1;
            cnt = cnt%1000000007;
        }
    }
    return cnt;*/
}

