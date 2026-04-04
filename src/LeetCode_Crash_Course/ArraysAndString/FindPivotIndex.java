package LeetCode_Crash_Course.ArraysAndString;

public class FindPivotIndex {
    public static void main(String[] args) {
        int [] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
    public static int pivotIndex(int[] nums) {
        int leftSum = 0,totalSum = 0;
        for(int x : nums) {
            totalSum+=x;
        }
        for(int i = 0; i < nums.length; i++) {
            if(leftSum == totalSum-leftSum-nums[i]) {
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}
