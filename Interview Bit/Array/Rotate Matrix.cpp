You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]


****solution:

void Solution::rotate(vector<vector<int> > &A) {
    /*vector<vector<int>>res = A;
    for(int i = 0; i < A.size(); i++) {
        for(int j = 0; j < A[0].size(); j++) {
            A[j][(A.size()-1)-i] = res[i][j];
        }
    }*/
    for(int i = 0; i< A.size(); i++) {
        for(int j = i+1; j < A.size(); j++) {
            swap(A[i][j],A[j][i]);
        }
    }
    for(int i = 0; i < A.size(); i++) {
        for(int j = 0; j < A.size()/2; j++) {
            swap(A[i][j],A[i][(A.size()-1)-j]);
        }
    }
}
