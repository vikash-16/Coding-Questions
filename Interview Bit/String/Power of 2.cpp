Find if Given number is power of 2 or not.
More specifically, find if given number can be expressed as 2^k where k >= 1.

Input:

number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
Output:

return 1 if the number is a power of 2 else return 0

Example:

Input : 128
Output : 1



*******solution::


/*string multiplybytwo(string A){
    int n = A.size();
    int carry = 0;
    int sum = 0;
    int temp = 0;
    string result;
    for(int i=n-1;i>=0;i--){
        temp = (A[i]-'0')*2;
        sum = (temp+carry)%10;
        carry = (temp+carry)/10;
        result += sum+'0';
    }
    if(carry) {
        result+=carry+'0';
    }
    reverse(result.begin(),result.end());
    return result;
}
int Solution::power(string A) {
    string str = "1";
    while(true){
        str = multiplybytwo(str);
        if(A == str)
            return 1;
        if(str.size()>A.size())
            return 0;
    }
}*/
int Solution::power(string A) {
    long long  k = 0;
    int i=0;
    int len = A.size();
    while(i<len)
    {
        k = k*10+(A[i]-'0');
        i++;
    }
    if(k == 1)
        return 0;
    int p = k-1;
    if((k & p) == 0)
        return 1;
    else
        return 0;
}
