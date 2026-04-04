Given an array of real numbers greater than zero in form of strings.
Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
Return 1 for true or 0 for false.

Example:

Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

You should return 1

as

0.6+0.7+0.4=1.7

1<1.7<2

Hence, the output is 1.

****solution:

int Solution::solve(vector<string> &A) {
    float a =stof(A[0]);
    float b = stof(A[1]);
    float c = stof(A[2]);
    for(int i = 3; i< A.size();i++) {
        if(1 < a+b+c && a+b+c < 2) {
            return 1;
        } else if(a+b+c > 2){
            if(a >b && a > c) {
                a = stof(A[i]);
            } else if(b > a && b > c) {
                b = stof(A[i]);
            } else if(c > a && c > b) {
                c = stof(A[i]);
            }
        } else {
            if(a < b && a < c) {
                a = stof(A[i]);
            } else if(b < a && b < c) {
                b = stof(A[i]);
            } else if(c < a && c < b) {
                c = stof(A[i]);
            }
        }
    }
    if(1 < a+b+c && a+b+c < 2) {
            return 1;
    } else {
        return 0;
    }
}

