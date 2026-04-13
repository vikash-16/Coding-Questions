package LeetCode75.Arrays_String;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int [][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new NumberOfProvinces().findCircleNum(isConnected));
    }
    public int findCircleNum(int[][] isConnected) {
        boolean [] visited = new boolean[isConnected.length];
        int provinces = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(visited[i] == false) {
                bfsHelper(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }
    public void bfsHelper(int[][] isConnected, boolean[] visited, int src) {
        if(visited[src] == true) return;
        Queue<Integer>queue = new ArrayDeque<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            Integer point = queue.poll();
            for(int i = 0; i < isConnected[src].length; i++) {
                if(isConnected[src][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    private void dfsHelper(int[][] isConnected, boolean[] visited, int src) {
        if(visited[src] == true) return;
        visited[src] = true;
        for(int i = 0; i < isConnected[src].length; i++) {
            if(isConnected[src][i] == 1 && visited[src] == false)
            dfsHelper(isConnected,visited,i);
        }
    }
}
