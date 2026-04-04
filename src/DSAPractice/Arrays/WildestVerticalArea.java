package DSAPractice.Arrays;

import java.util.Arrays;

public class WildestVerticalArea {
    public static void main(String[] args) {
        int [][]points = {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
        System.out.println(maxWidthOfVerticalArea(points));
    }
    public static int maxWidthOfVerticalArea(int[][] points) {
        int maximumWidth = Integer.MIN_VALUE;
        Arrays.sort(points,(a,b)->(a[0]-b[0]));
        for(int i = 1; i < points.length; i++) {
            maximumWidth = Math.max(maximumWidth,Math.abs(points[i][0]-points[i-1][0]));
        }
        return maximumWidth;
    }
}
