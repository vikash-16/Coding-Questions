Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False


****solution:

int Solution::isPalindrome(int A) {
    long long int res = 0;
    long long int num,i;
    long long int n = A;
    while(n > 0) {
        num = n%10;
        n = n/10;
        res = res*10+num;
    }
    if(res == A) {
        return 1;
    } else {
        return 0;
    }
}

