package DSAPractice.Arrays;

public class Sqrt {
    public static void main(String[] args) {
        int x = 15;
        System.out.println(new Sqrt().mySqrt(x));
    }
    public int mySqrt(int x) {
        if(x < 2) {
            return x;
        }
        int start = 1,end = x;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(mid  == x/mid) {
                return mid;
            }
            if(mid > x/mid) {
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return end;
    }
}
