Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Example:

5 / 2 = 2
Also, consider if there can be overflow cases. For overflow case, return INT_MAX.

Note: INT_MAX = 2^31 - 1




*******solution::



int Solution::divide(int A, int B) {
    long long sign = 1;
    long long quotient = 0;
    long long m = A;
    long long n = B;
    if(m < INT_MIN) {
        return m;
    }
    if(n < INT_MIN) {
        return n;
    }
    if(m<0 && n < 0) {
        sign = 1;
        m = abs(m);
        n = abs(n);
    }else if(n < 0) {
        sign = -1;
        n = abs(n);
    }else if(m<0) {
        sign = -1;
        m = abs(m);
    }
    while(m >= n) {
        m = m-n;
        quotient++;
    }
    if(quotient >= INT_MAX) {
        return INT_MAX;
    }
    return quotient*sign;
}

/*int Solution::divide(int dividend, int divisor) {
    int sign = 1;
    if (dividend<0){sign = -sign;}
    if (divisor<0){sign = -sign;}

    unsigned long long tmp = abs((long long)dividend);
    unsigned long long tmp2 = abs((long long)divisor);

    unsigned long c = 1;
    while (tmp2 < tmp){
        tmp2 = tmp2<<1;
        c = c<<1;
    }

    long long res = 0;
    while (tmp>=abs((long long)divisor)){
        while (tmp2 <= tmp){
            tmp -= tmp2;
            res = res+c;
        }
        tmp2=tmp2>>1;
        c=c>>1;
    }

    return (sign*res >= INT_MAX ||  sign*res < INT_MIN) ? INT_MAX : sign*res;
}*/
