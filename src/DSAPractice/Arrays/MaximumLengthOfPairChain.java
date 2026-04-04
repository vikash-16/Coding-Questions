package DSAPractice.Arrays;

import java.util.Arrays;

public class MaximumLengthOfPairChain {

    public static void main(String[] args) {
        int [][] pairs = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
        System.out.println(new MaximumLengthOfPairChain().findLongestChain(pairs));
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->(a[1]-b[1]));
        int count = 1;
        int [] pair = pairs[0];
        for(int [] ele: pairs) {
            if(pair[1] < ele[0]) {
                pair = ele;
                count++;
            }
        }
        return count;
    }
}
