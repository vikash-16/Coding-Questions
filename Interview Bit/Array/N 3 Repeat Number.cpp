You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1
1 occurs 3 times which is more than 5/3 times.


*******solution:

int Solution::repeatedNumber(const vector<int> &A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details

    int n = A.size();
    int num1,num2;
    int count1 = 0,count2 = 0;
    for(int i = 0; i < n; i++) {
        if(num1 == A[i]) {
            count1++;
        } else if(num2 == A[i]) {
            count2++;
        } else if(count1 == 0) {
            count1++;
            num1 = A[i];
        }else if(count2 == 0) {
            count2++;
            num2 = A[i];
        }else {
            count1--;
            count2--;
        }
    }
    count1 = 0;
    count2 = 0;
    for(int i = 0; i< n; i++) {
        if(A[i] == num1) {
            count1++;
        }else if(A[i] == num2) {
            count2++;
        }
    }
        if(count1 > n/3) {
            return num1;
        }
        if(count2 > n/3) {
            return num2;
        }
    return -1;
}
    /*int n = A.size();
    int num1,num2,num3;
    int count1 = 0,count2 = 0,count3 = 0;
    for(int i = 0; i < n; i++) {
        if(num1 == A[i]) {
            count1++;
        } else if(num2 == A[i]) {
            count2++;
        } else if(num3 == A[i]) {
            count3++;
        } else if(count1 == 0) {
            count1++;
            num1 = A[i];
        } else if(count2 == 0) {
            count2++;
            num2 = A[i];
        }else if(count3 == 0) {
            count3++;
            num3 = A[i];
        }
    }
    if(count1 > n/3) {
        return num1;
    }
    if(count2 > n/3) {
        return num2;
    }
    if(count3 > n/3) {
        return num3;
    }
    return -1;*/

