package DSAPractice.Math;

public class DetermineifaCellIsReachableAtAGivenTime {
    public static void main(String[] args) {
        System.out.println(new DetermineifaCellIsReachableAtAGivenTime().isReachableAtTime(2,4,7,7,6));
    }
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx-fx), height = Math.abs(sy-fy);
        if(width == 0 && height == 0 && t == 1) return false;
        return t >= Math.max(width,height);
    }
}
