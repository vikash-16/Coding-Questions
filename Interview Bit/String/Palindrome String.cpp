
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem



***solution::

int Solution::isPalindrome(string A) {
    transform(A.begin(), A.end(), A.begin(), ::toupper);
    int length,i,j;
    length=A.length();
    i=0;
    j=length-1;
    while(i<j)
    {
        if((A[i]>=65 && A[i]<=90)|| (A[i]>=48 && A[i]<=57))
        {
            if((A[j]>=65 && A[j]<=90)|| (A[j]>=48 && A[j]<=57))
            {
                if(A[i]==A[j])
                {
                    i++;
                    j--;
                }
                else
                {
                    return 0;

                }
            }
            else
            {
                j--;
            }
        }
        else
        {
            i++;
        }
    }
    return 1;
}
