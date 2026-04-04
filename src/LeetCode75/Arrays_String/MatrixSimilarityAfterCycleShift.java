package LeetCode75.Arrays_String;

public class MatrixSimilarityAfterCycleShift {
    public static void main(String[] args) {
        boolean b = new MatrixSimilarityAfterCycleShift().areSimilar(new int[][]{{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}}, 2);
        System.out.println(b);
    }

    public boolean areSimilar(int[][] mat, int k) {

        /*---------Note:BruteForce Solution---------------*/
        /*int[][] clone = new int[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            clone[i] = mat[i].clone();
        }
        while (k > 0) {
            for (int i = 0; i < mat.length; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < mat[i].length - 1; j++) {
                        clone[i][j] = clone[i][j] ^ clone[i][j + 1];
                        clone[i][j + 1] = clone[i][j] ^ clone[i][j + 1];
                        clone[i][j] = clone[i][j] ^ clone[i][j + 1];
                    }
                } else {
                    for (int j = mat[i].length - 1; j > 0; j--) {
                        clone[i][j] = clone[i][j] ^ clone[i][j - 1];
                        clone[i][j - 1] = clone[i][j] ^ clone[i][j - 1];
                        clone[i][j] = clone[i][j] ^ clone[i][j - 1];
                    }
                }
            }
            k--;
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != clone[i][j]) {
                    return false;
                }
            }
        }
        return true;*/

        /* Note: Optimized Solution*/
        int m = mat.length, n = mat[0].length;
        k%=m;
        for(int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] != mat[i][(j+k)%n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
