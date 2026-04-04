package DSAPractice;

import java.util.*;

public class ZeroOneMatrix {
    int [] dir = {0,1,0,-1,0};
    public static void main(String[] args) {
        int [][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int m = mat.length,n = mat[0].length;
        mat = new ZeroOneMatrix().updateMatrix(mat);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        Queue<int []> queue = new ArrayDeque<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                }else {
                    mat[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0],col = poll[1];
            for(int i = 0; i < dir.length-1;i++) {
                int newRow = row+dir[i], newCol = col+dir[i+1];
                if(newRow < 0 || newRow >= mat.length || newCol < 0 || newCol >= mat[0].length || mat[newRow][newCol] != -1) continue;
                mat[newRow][newCol] = mat[row][col]+1;
                queue.offer(new int[]{newRow,newCol});
            }
        }
        return mat;
    }
}
