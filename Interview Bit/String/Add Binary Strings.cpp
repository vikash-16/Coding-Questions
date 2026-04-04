Given two binary strings, return their sum (also a binary string).

Example:

a = "100"

b = "11"
Return a + b = “111”.



****solution::


string Solution::addBinary(string A, string B) {
    int len1 = A.size();
    int len2 = B.size();
    char carry = '0';
    int i = len1-1,j = len2-1;
    string res;
    while(i >= 0 && j >= 0) {
        if(A[i] == '0' && B[j] == '0' && carry == '0') {
            res.push_back('0');
            carry = '0';
        } else if(A[i] == '0' && B[j] == '0' && carry == '1') {
            res.push_back('1');
            carry = '0';
        } else if(A[i] == '0' && B[j] == '1' && carry == '0') {
            res.push_back('1');
            carry = '0';
        }else if(A[i] == '0' && B[j] == '1' && carry == '1') {
            res.push_back('0');
            carry = '1';
        }else if(A[i] == '1' && B[j] == '0' && carry == '0') {
            res.push_back('1');
            carry = '0';
        }else if(A[i] == '1' && B[j] == '0' && carry == '1') {
            res.push_back('0');
            carry = '1';
        }else if(A[i] == '1' && B[j] == '1' && carry == '0') {
            res.push_back('0');
            carry = '1';
        }else if(A[i] == '1' && B[j] == '1' && carry == '1') {
            res.push_back('1');
            carry = '1';
        }
        i--;
        j--;
    }
    if(i >= 0) {
        while(i >= 0) {
            if(A[i] == '0' && carry == '0') {
                res.push_back('0');
                carry = '0';
            }else if(A[i] == '0' && carry == '1') {
                res.push_back('1');
                carry = '0';
            }else if(A[i] == '1' && carry == '0') {
                res.push_back('1');
                carry = '0';
            }else if(A[i] == '1' && carry == '1') {
                res.push_back('0');
                carry = '1';
            }
            i--;
        }
    }

    if(j >= 0) {
        while(j >= 0) {
            if(B[j] == '0' && carry == '0') {
                res.push_back('0');
                carry = '0';
            }else if(B[j] == '0' && carry == '1') {
                res.push_back('1');
                carry = '0';
            }else if(B[j] == '1' && carry == '0') {
                res.push_back('1');
                carry = '0';
            }else if(B[j] == '1' && carry == '1') {
                res.push_back('0');
                carry = '1';
            }
            j--;
        }
    }
    if(carry == '1') {
        res.push_back('1');
    }
    reverse(res.begin(),res.end());
    return res;
}

