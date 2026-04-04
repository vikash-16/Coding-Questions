package DSAPractice.Arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MaxWidthOfVerticalArea {
    public static void main(String[] args) {
        int [][]points = {{8,7},{9,9},{7,4},{9,7},{1,8}};
        int result = new MaxWidthOfVerticalArea().maxWidthOfVerticalArea(points);
        System.out.println(result);
    }
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int area = Integer.MIN_VALUE;
        for(int i = 1; i < points.length; i++) {
            area = Math.max(area,(points[i][0]-points[i-1][0]));
        }
        return area;
    }
}
