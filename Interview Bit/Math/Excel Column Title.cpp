
Problem Description

Given a positive integer A, return its corresponding column title as appear in an Excel sheet.



Problem Constraints
1 <= A <= 1000000000



Input Format
First and only argument is integer A.



Output Format
Return a string, the answer to the problem.



Example Input
Input 1:

 A = 1
Input 2:

 A = 28


Example Output
Output 1:

 "A"
Output 2:

 "AB"


Example Explanation
Explanation 1:

 1 -> A
Explanation 2:

1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB


*****solution:

string Solution::convertToTitle(int A) {
    string s ="";
    int temp = 0;
    while(A >0) {
        temp = A%26;
        if(temp == 0) {
            A = (A/26)-1;
            s+= 'Z';
        } else {
            A = A/26;
            s+=temp+'A'-1;
    }
    }
    reverse(s.begin(),s.end());
    return s;
}
