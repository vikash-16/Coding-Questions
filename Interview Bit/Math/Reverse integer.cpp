Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer


*****solution:

int Solution::reverse(int A) {
    long int res = 0;
    long int temp1 = abs(A);
    long int temp2 = 0;
    while(temp1 > 0) {
        temp2 = temp1 % 10;
        res = (res * 10) + temp2;
        temp1 = temp1/10;
    }
    if(A < 0) {
        res = -1 * res;
    }
    if(res > INT_MAX || res < INT_MIN) {
        return 0;
    }
    return res;
}

