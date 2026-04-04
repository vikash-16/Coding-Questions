package DSAPractice.Arrays;

import java.util.Arrays;

public class SumofAbsoluteDifferencesinaSortedArray {
    public static void main(String[] args) {
        int [] nums = {2,3,5};
        System.out.println(Arrays.toString(new SumofAbsoluteDifferencesinaSortedArray().getSumAbsoluteDifferences(nums)));
    }
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int result[] = new int[nums.length];
        int pre[] = new int[nums.length];
        pre[0] = nums[0];
        int totalSum = 0;
        for(int i = 1; i < nums.length; i++) {
            pre[i] = pre[i-1]+nums[i];
        }
        totalSum = pre[pre.length-1];
        for(int i = 0; i < nums.length; i++) {
            result[i] = Math.abs(pre[i]-(nums[i]*(i+1)))+Math.abs((totalSum-pre[i])-(nums[i]*((nums.length-i)-1)));
        }
        return result;
    }
}
