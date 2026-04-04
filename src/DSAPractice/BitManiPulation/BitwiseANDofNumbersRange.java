package DSAPractice.BitManiPulation;

public class BitwiseANDofNumbersRange {
    public static void main(String[] args) {
        int left = 2, right = 3;
        System.out.println(new BitwiseANDofNumbersRange().rangeBitwiseAnd(left,right));
    }
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right = right&(right-1);
        }
        return right&left;
        /*if(left == 0 || right == 0) return 0;
        if(left == right ) return left;
        double maxDigitInLeft = Math.floor(Math.log10(left) / Math.log10(2));
        double maxDigitInRight = Math.floor(Math.log10(right) / Math.log10(2));
        if(maxDigitInLeft == maxDigitInRight) {
            if(right-left == 1) {
                return left;
            }
            return (int)Math.pow(2,maxDigitInLeft);
        }
        return 0;*/
    }
}
