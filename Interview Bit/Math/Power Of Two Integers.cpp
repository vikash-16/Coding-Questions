Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True
as 2^2 = 4.

********solution:


int Solution::isPower(int A) {
    int res;
    if(A == 0 || A == 1) {
        return 1;
    }

    for(int i = 2; i <=sqrt(A);i++) {
        res = A;
        while(res%i == 0) {
            res = res/i;
            if(res == 1) {
                return 1;
            }
        }
    }
    return 0;
}


