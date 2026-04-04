package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    public static void main(String[] args) {
        int [][]points = {{2,10},{-9,-9},{0,8},{-2,-2},{8,9},{-10,-7},{-5,2},{-4,-9}};
        int k = 7;
        System.out.println(new KClosestPointstoOrigin().kClosest(points,k));
    }
    public class Point {
        int [] point;
        int originDist;
        Point(int [] point,int dist) {
            this.point = point;
            this.originDist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        List<int []> result = new ArrayList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>((p1,p2)->p2.originDist-p1.originDist);
        for(int [] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            pq.add(new Point(point,dist));
            if(pq.size() > k) {
                pq.poll();
            }
        }
        while (k > 0) {
            result.add(pq.poll().point);
            k--;
        }
        return result.toArray(int [][]::new);
    }
}
