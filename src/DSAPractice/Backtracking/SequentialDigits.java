package DSAPractice.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        int low = 1000, high = 13000;
        System.out.println(new SequentialDigits().sequentialDigits(low,high));
    }
    List<Integer>result = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        for(int i = 1; i <= 9; i++) {
            int seqDigit = i;
            int nextDigit = i+1;
            while (seqDigit <= high && nextDigit <= 9) {
                seqDigit = seqDigit*10+nextDigit;
                if(low <= seqDigit && seqDigit <= high) {
                    result.add(seqDigit);
                }
                nextDigit++;
            }
            Collections.sort(result);
        }
        return result;
    }
}
