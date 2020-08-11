Validate if a given string is numeric.

Examples:

"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Clarify the question using “See Expected Output”

Is 1u ( which may be a representation for unsigned integers valid?
For this problem, no.
Is 0.1e10 valid?
Yes
-01.1e-10?
Yes
Hexadecimal numbers like 0xFF?
Not for the purpose of this problem
3. (. not followed by a digit)?
No
Can exponent have decimal numbers? 3e0.1?
Not for this problem.
Is 1f ( floating point number with f as prefix ) valid?
Not for this problem.
How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
Not for this problem.
How about integers preceded by 00 or 0? like 008?
Yes for this problem



****solution::


int Solution::isNumber(const string A) {
    int res = 0;
    int i = 0,j = A.size()-1;
    while(i < A.size() && A[i] == ' ') {
        i++;
    }
    while(j >= 0 && A[j] == ' ') {
        j--;
    }
    if(i > j) {
        return 0;
    }
    if(i == j && !(A[i] >= 48 && A[i]<=57)) {
        return 0;
    }
    if(A[i] != '.' && A[i] != '+' && A[i] != '-' && !(A[i] >= 48 && A[i]<=57)) {
        return 0;
    }
    bool dot_or_e = false;
    for(;i<=j; i++) {
        if(A[i] != 'e' && A[i] != '.' && A[i] != '+' && A[i] != '-' && !(A[i] >= 48 && A[i]<=57)) {
            return 0;
        }
        if(A[i] == '.') {
            if(dot_or_e == true) {
                return 0;
            }
            if(i+1 > A.size()) {
                return 0;
            }
            if(!(A[i+1] >= 48 && A[i+1]<=57)) {
                return 0;
            }
        } else if(A[i]=='e') {
            dot_or_e = true;
            if(!(A[i-1] >= 48 && A[i-1]<=57)) {
                return 0;
            }
            if(i+1 > A.size()) {
                return 0;
            }
            if(A[i+1] != '+' && A[i+1] != '-' && !(A[i+1] >= 48 && A[i+1]<=57)) {
                return 0;
            }

        }

    }
    return 1;

}

