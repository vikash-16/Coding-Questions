
Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm’s runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

 Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
Constraints

1 <= N <= 10^6
1 <= A[i], B <= 10^9
For Example

Input 1:
    A = [5, 7, 7, 8, 8, 10]
    B = 8
Output 1:
    [3, 4]
Explanation 1:
    First occurence of 8 in A is at index 3
    Second occurence of 8 in A is at index 4
    ans = [3, 4]

Input 2:
    A = [5, 17, 100, 111]
    B = 3
Output 2:
    [-1, -1]


****solution::

int bs_first(const vector<int> &A,int B) {
    int low = 0;
    int high = A.size()-1;
    int first = INT_MAX;
    while(low <= high) {
        int mid = low+(high-low)/2;
        if(A[mid] == B) {
            first = min(first,mid);
            high = mid-1;
        }else if(A[mid] > B) {
            high = mid-1;
        }else{
            low = mid+1;
        }
    }
    if(first != INT_MAX) {
        return first;
    }
    return -1;
}
int bs_last(const vector<int> &A,int B) {
    int low = 0;
    int high = A.size()-1;
    int last = INT_MIN;
    while(low <= high) {
        int mid = low+(high-low)/2;
        if(A[mid] == B) {
            last = max(last,mid);
            low = mid+1;
        }else if(A[mid] > B) {
            high = mid-1;
        }else{
            low = mid+1;
        }
    }
    if(last != INT_MIN) {
        return last;
    }
    return -1;
}
vector<int> Solution::searchRange(const vector<int> &A, int B) {
    vector<int>res;
    int pos1 = bs_first(A,B);
    int pos2 = bs_last(A,B);
    res.push_back(pos1);
    res.push_back(pos2);
    return res;
}
/*vector<int> Solution::searchRange(const vector<int> &A, int B) {
    vector<int>res;
    int pos1 = -1;
    int pos2 = -1;
    int i,j;
    for(int i = 0; i < A.size(); i++) {
        if(A[i] == B) {
            pos1 = i;
            break;
        }
    }
    for(int j = A.size()-1; j >= i; j--) {
        if(A[j] == B) {
            pos2 = j;
            break;
        }
    }
    res.push_back(pos1);
    res.push_back(pos2);
    return res;

}
*/
