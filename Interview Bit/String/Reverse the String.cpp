Given a string A.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.

Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.

If there are multiple spaces between words, reduce them to a single space in the reversed string.



Input Format

The only argument given is string A.
Output Format

Return the string A after reversing the string word by word.
For Example

Input 1:
    A = "the sky is blue"
Output 1:
    "blue is sky the"

Input 2:
    A = "this is ib"
Output 2:
    "ib is this"




********solution::


string Solution::solve(string A) {
    int n = A.size();
    int i = n-1;
    int j = n-1;
    int k;
    int flag = 0;
    string temp = "";
    string res;
    while(i >= 0) {
        if(A[i] != ' ') {
            i--;
        }else {
            k = i+1;
            while(k <= j) {
                temp.push_back(A[k]);
                k++;
            }
            res+=temp;
            res+=' ';
            temp.clear();
            i--;
            j = i;
            flag = 1;
        }
    }
    for(i = 0;i <= j;i++) {
        temp.push_back(A[i]);
    }
    res+= temp;
    if(flag) {
        return res;
    }
    else {
        res = A;
        return res;
    }
}

