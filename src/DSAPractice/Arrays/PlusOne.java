package DSAPractice.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9};
        System.out.println(plusOne(digits));
        Math.sqrt(new Double(4));
    }

    private static int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; i--) {
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        if(digits[0] == 0) {
            int len = digits.length + 1;
            int[] result = new int[len];
            result[0] = 1;
            return result;
        }
        return null;
    }
}
