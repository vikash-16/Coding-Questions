Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9



*****solution




int Solution::atoi(const string A) {
    int sign = 1;
    long int len = A.size();
    long long int res = 0;
    long int i = 0;
    while(A[i] == ' ') {
        i++;
    }
    if(A[i] == '-') {
        sign = -1;
        i++;
    }
    if(A[i] == '+') {
        sign = 1;
        i++;
    }
    while(i < len ) {
        if(isdigit(A[i])) {
            res = res*10+(int)(A[i]-'0');
        }else {
            break;
        }
        i++;
        if(res > INT_MAX) {
            if(sign == -1) {
                return INT_MIN;
            }else {
                return INT_MAX;
            }
        }
    }
    return sign * res;
}

