Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

******solution******


vector<int> Solution::plusOne(vector<int> &A) {
    if(A[0] == 0 && A.size() > 1) {
        A.erase(A.begin());
    }
    vector<int>res;
    string s = "";
    int n = A.size();
    for(auto i : A)
        s+=to_string(i);
    unsigned long long num = 0;
    stringstream str(s);
    str>>num;
    num = num + 1;
    while(num > 0) {
        res.push_back(num%10);
        num = num/10;
    }
    reverse(res.begin(),res.end());
    return res;
}
