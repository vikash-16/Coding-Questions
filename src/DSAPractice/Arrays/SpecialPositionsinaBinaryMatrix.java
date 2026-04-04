package DSAPractice.Arrays;

public class SpecialPositionsinaBinaryMatrix {
    public static void main(String[] args) {
        int [][] mat = {{1,0,0},{0,0,1},{1,0,0}};
        System.out.println(new SpecialPositionsinaBinaryMatrix().numSpecial(mat));
    }
    public int numSpecial(int[][] mat) {
        int count = 0;
        int [] row = new int[mat.length];
        int [] col = new int[mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (row[i] == 1 && col[j] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
