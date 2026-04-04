package DSAPractice.Strings;

import java.util.Arrays;

public class MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {
        String s = "0100";
        System.out.println(new MinimumChangesToMakeAlternatingBinaryString().minOperations(s));
    }
    public int minOperations(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int startWith0 = 0;
        for(int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (array[i]  == '1') {
                    startWith0++;
                }
            } else {
                if (array[i]  == '0') {
                    startWith0++;
                }
            }
        }
        return Math.max(startWith0,n-startWith0);
    }
}
