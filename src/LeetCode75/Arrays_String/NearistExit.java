package LeetCode75.Arrays_String;

import java.util.*;

public class NearistExit {
    static void main() {
       char[][] maze = {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
       int []entrance = {1,0};
        int i = new NearistExit().nearestExit(maze, entrance);
        System.out.println(i);

    }
    class Point{
        int x;
        int y;
        int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int nearestExit = Integer.MAX_VALUE;
        Queue<Point>queue = new ArrayDeque<>();
        Set<Point>visited = new HashSet<>();
        int m = maze.length,n = maze[0].length;
        queue.add(new Point(entrance[0],entrance[1],0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point point = queue.poll();
                if(visited.contains(point)) {
                    continue;
                }
                visited.add(point);
                if((point.x != entrance[0] || point.y != entrance[1]) && (point.x >= m-1 || point.x <=0 || point.y <= 0 || point.y >= n-1)) {
                    nearestExit = Math.min(nearestExit,point.d);
                    continue;
                }
                int up = point.x-1,down = point.x+1,left = point.y-1,right = point.y+1;
                if(up >= 0 && maze[up][point.y] == '.') {
                    queue.add(new Point(up,point.y, point.d+1));
                }
                if(down < m && maze[down][point.y] == '.'){
                    queue.add(new Point(down,point.y, point.d+1));
                }
                if(left >= 0 && maze[point.x][left] == '.') {
                    queue.add(new Point(point.x,left,point.d+1));
                }
                if(right < n && maze[point.x][right] == '.') {
                    queue.add(new Point(point.x,right,point.d+1));
                }
            }

        }
        return nearestExit == Integer.MAX_VALUE ? -1: nearestExit;
    }
}
