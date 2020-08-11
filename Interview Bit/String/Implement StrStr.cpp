int Solution::strStr(const string A, const string B) {
    int i,j,k;
    int m = A.length();
    int n = B.length();
    int flag;
    for(i = 0; i < m; i++) {
        k = 0;
        flag = 1;
        for(j = i; j < n+i; j++) {
            if(A[j] == A[k]) {
                k++;
            } else {
                flag = 0;
                break;
            }
        }
        if(flag) {
            return i;
        }
    }
    return -1;
}

