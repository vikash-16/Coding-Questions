Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input :
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input :
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]



******solution::


vector<int> Solution::intersect(const vector<int> &A, const vector<int> &B) {
    vector<int>res;
    int len1 = A.size();
    int len2 = B.size();
    int i = 0;
    int j = 0;
    while(i < len1 && j < len2) {
        if(A[i] == B[j]) {
            res.push_back(A[i]);
            i++;
            j++;
        }else if(A[i] < B[j]) {
            i++;
        }else if(A[i] > B[j]) {
            j++;
        }
    }
    return res;
}

