package DSAPractice.Math;

public class ImplementingPow {
    public static void main(String[] args) {
        double x = 2.0;
        int n = -4;
        System.out.println(new ImplementingPow().myPow(x,n));
    }
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n == 1) return x;
        double temp = myPow(x, n / 2);
        if(n % 2 == 0) {
            return temp* temp;
        }else {
            if(n > 0) {
                return (temp*temp*x);
            }else {
                return (temp*temp)/x;
            }
        }
    }
}
