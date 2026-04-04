package DSAPractice.Arrays;

import java.util.Arrays;

public class ConstructProductMatrix {
    public static void main(String[] args) {
        int [][] grid = {{137048688,395034800,51674655,853813001,66020662,108245761}};
        System.out.println(Arrays.asList(new ConstructProductMatrix().constructProductMatrix(grid)).toString());
    }
    public int[][] constructProductMatrix(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length;
        int [][] prefix = new int [rowLen][colLen], suffix = new int [rowLen][colLen];
        int prefixProd = 1,suffixProd = 1;
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                grid[i][j] = grid[i][j]%12345;
                prefixProd = (prefixProd*(grid[i][j]%12345))%12345;
                suffixProd = (suffixProd*(grid[rowLen-i-1][colLen-j-1]%12345))%12345;
                prefix[i][j] = prefixProd;
                suffix[rowLen-i-1][colLen-j-1] = suffixProd;
            }
        }
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen ; j++) {
                if (i == 0 && j == 0) {
                    prefixProd = 1;
                }
                else if (j != 0) {
                    prefixProd = prefix[i][j - 1];
                }
                else {
                    prefixProd = prefix[i - 1][colLen - 1];
                }

                if (i == rowLen - 1 && j == colLen -1) {
                    suffixProd = 1;
                }
                else if (j + 1 < colLen) {
                    suffixProd = suffix[i][j + 1];
                }
                else {
                    suffixProd = suffix[i + 1][0];
                }

                grid[i][j] = (prefixProd * suffixProd) % 12345;
            }
        }
        return grid;
    }
}

