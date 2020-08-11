Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

*****solution:

bool mycompare(string x,string y) {
    return x+y > y+x;
}
string Solution::largestNumber(const vector<int> &A) {
    vector<string>res;
    for(int i = 0; i < A.size();i++) {
        res.push_back(to_string(A[i]));
    }
    sort(res.begin(),res.end(),mycompare);
    if(res[0] == "0") {
        return "0";
    }
    string str = "";
    for(int i = 0; i < res.size();i++) {
        str+=res[i];
    }
    return str;
}

