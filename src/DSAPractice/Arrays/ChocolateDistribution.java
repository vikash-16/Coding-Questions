package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ChocolateDistribution {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 4, 1, 9, 56, 7, 9, 12));
        System.out.println(findMinDiff(a,a.size(),5));
    }
    static long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long diff = Long.MAX_VALUE;
        for(int i = 0; i <= n-m; i++) {
            long currDiff = a.get(m-1+i)-a.get(i);
            diff = Math.min(diff,currDiff);
        }
        return diff;
    }
}
