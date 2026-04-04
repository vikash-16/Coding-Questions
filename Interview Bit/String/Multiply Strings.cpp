Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
For example,
given strings "12", "10", your answer should be “120”.



*******solution::


string Solution::multiply(string A, string B) {
    int len1 = A.size();
    int len2 = B.size();
    int carry = 0;
    int sum = 0;
    if(A == "0" || B == "0")
        return "0";
    string res(len1+len2,'0');
    for(int i = len1-1; i >= 0; i--) {
        carry = 0;
        for(int j = len2-1; j >= 0; j--) {
            sum = carry+((A[i]-'0')*(B[j]-'0')) + (res[i+j+1]-'0');
            carry = sum/10;
            sum = sum % 10;
            res[i+j+1] = sum+'0';
        }
        if(carry) {
            res[i]+= carry;
        }
    }
    int pos = 0;
    while(res[pos] == '0') {
        pos++;
    }
    return res.substr(pos);
}

