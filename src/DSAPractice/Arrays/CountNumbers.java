package DSAPractice.Arrays;

public class CountNumbers {
    public static void main(String[] args) {
        System.out.println(new CountNumbers().rotatedDigits(10));
    }
    public int rotatedDigits(int n) {
        int totalNumbers = 0;
        for(int i = 1; i <= n; i++) {
            if(getCountNumbers(i) > 0) {
                totalNumbers++;
            }
        }
        return totalNumbers;
    }

    private int getCountNumbers(int num) {
        int count = 0;
        while (num > 0) {
            int rem = num % 10;
            if(rem == 3 || rem == 4 || rem == 7) return 0;
            if(rem == 2 || rem == 5 || rem == 6 || rem == 9) count++ ;
            num = num/10;
        }
        return count;
    }
}
