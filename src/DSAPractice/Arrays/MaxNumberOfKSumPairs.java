package DSAPractice.Arrays;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int k = 5;
        System.out.println(new MaxNumberOfKSumPairs().maxOperations(nums,k));
    }
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int count = 0;
        while(i < j) {
            if(nums[i]+nums[j] == k) {
                count++;
                i++;
                j--;
            }else if(nums[i]+nums[j] < k) {
                i++;
            }else {
                j--;
            }
        }
        return count;
    }
}
