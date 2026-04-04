The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.



******solution::


string Solution::countAndSay(int A) {
    int count;
    int j;
    string temp;
    string res;
    if(A==1) {
        return "1";
    }
    if(A == 2) {
        return "11";
    }
    res = "11";
    for(int i = 3; i<= A; i++) {
        count = 1;
        temp = "";
        res += "$";
        int len = res.length();
        for(int j = 1; j < len; j++) {
            if(res[j-1] != res[j]) {
                temp +=to_string(count);
                temp += res[j-1];
                count = 1;
            } else {
                count++;
            }
        }
        res = temp;
    }
    return res;
}

