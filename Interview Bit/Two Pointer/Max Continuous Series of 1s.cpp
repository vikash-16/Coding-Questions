You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input :
Array = {1 1 0 1 1 0 0 1 1 1 }
M = 1

Output :
[0, 1, 2, 3, 4]

*****solution::

vector<int> Solution::maxone(vector<int> &A, int B) {
     int left = 0, count = 0, start,end = 0;
    for (int right = 0; right < A.size(); right++) {
        if (!A[right]) {
            count++;
        }
        while (count > B) {
            if (!A[left++]) {
                count--;
            }
        }
        if (end < right - left + 1) {
            end = right - left + 1;
            start = left;
        }
    }
    vector<int> res;
    for (int i = 0; i < end; i++) res.push_back(start + i);
    return res;
}

