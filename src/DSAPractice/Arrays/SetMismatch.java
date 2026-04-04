package DSAPractice.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    public static void main(String[] args) {
        int [] nums = {1,2,2,4};
        System.out.println(Arrays.toString(new SetMismatch().findErrorNums(nums)));
    }
    public int[] findErrorNums(int[] nums) {
        Set<Integer> dict = new HashSet<>();
        int [] result = new int [2];
        int sum = 0;
        int totalSum = (nums.length*(nums.length+1))/2;
        for(int n : nums) {
            sum+=n;
            if(dict.contains(n)) {
                result[0] = n;
            }else {
                dict.add(n);
            }
        }
        result[1] = result[0]+totalSum-sum;
        return result;
    }
}
