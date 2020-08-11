Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.



Input Format:

The first and the only argument contains an integer, A.
Output Format:

Return a 2-d matrix of size A x A satisfying the spiral order.
Constraints:

1 <= A <= 1000
Examples:

Input 1:
    A = 3

Output 1:
    [   [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]   ]

Input 2:
    4

Output 2:
    [   [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]   ]



*****solution:

vector<vector<int> > Solution::generateMatrix(int A) {
    vector<vector<int>>res(A,vector<int>(A,0));
    int left = 0,right = A-1,top = 0,bottom = A-1;
    int i = 0;
    int dir = 0;
    while(top <= bottom && left <= right) {
        while(i < A*A) {
            for(int j = left; j <= right; j++) {
                if(dir == 0) {
                    res[top][j] = i+1;
                    i++;
                }
            }
            top++;
            dir++;
            for(int j = top; j <= bottom; j++) {
                if(dir == 1) {
                    res[j][right] = i+1;
                    i++;
                }

            }
            right--;
            dir++;
            for(int j = right; j >= left; j--) {
                if(dir == 2) {
                    res[bottom][j] = i+1;
                    i++;
                }
            }
            bottom--;
            dir++;
            for(int j = bottom; j >= top; j--) {
                if(dir == 3) {
                    res[j][left] = i+1;
                    i++;
                }
            }
            dir++;
            left++;
            dir = dir % 4;
        }

    }
    return res;

}
