package DSAPractice.BitManiPulation;

public class Numberof1Bits {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(new Numberof1Bits().hammingWeight(n));
    }
    public int hammingWeight(int n) {
        int countBits = 0;
        for(int i = 0; i < 32; i++) {
            int leftShift = 1 << i;
            if((n&leftShift) == leftShift) {
                countBits++;
            }
        }
        return countBits;
    }
}
