package DSAPractice.Math;

public class SumOfSquareNumber {
    public static void main(String[] args) {
        int c = 5;
        System.out.println(new SumOfSquareNumber().judgeSquareSum(c));
    }
    public boolean judgeSquareSum(int c) {
        for(int a = 0; a* a <= c; a++) {
            double b = Math.sqrt(c-a*a);
            if((int)b == b) {
                return true;
            }
        }
        return false;
    }

}
