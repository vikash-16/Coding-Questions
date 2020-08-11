Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:


Input:

1 2 3
4 5 6
7 8 9

Return the following :

[
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input :
1 2
3 4

Return the following  :

[
  [1],
  [2, 3],
  [4]
]

****solution:

vector<vector<int> > Solution::diagonal(vector<vector<int> > &A) {
    int n = A.size();
    int m = n+n-1;
    int count = 0;
    vector<vector<int>>res(m);
    int itr1 = 0;
    int i = 0;
    int j = 0;
    while(itr1 < n) {
        i = 0;
        j = itr1;
        while(i < n && j>=0) {
            res[count].push_back(A[i][j]);
            i++;
            j--;
        }
        itr1++;
        count++;
    }
    itr1 = 1;
    while(itr1 < n) {
        i = itr1;
        j = n-1;
        while(i < n && j >=0) {
            res[count].push_back(A[i][j]);
            i++;
            j--;
        }
        itr1++;
        count++;
    }
    return res;
}

