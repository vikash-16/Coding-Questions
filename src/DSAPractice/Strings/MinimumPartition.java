package DSAPractice.Strings;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumPartition {
    public static void main(String[] args) {
        String n = "32";
        System.out.println(minPartitions(n));
    }
    public static int minPartitions(String n) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n.length(); i++) {
            res = Math.max(res,n.charAt(i)-'0');
        }
        return res;
    }
}
