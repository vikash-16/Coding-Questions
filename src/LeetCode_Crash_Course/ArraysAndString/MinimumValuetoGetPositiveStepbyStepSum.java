package LeetCode_Crash_Course.ArraysAndString;

public class MinimumValuetoGetPositiveStepbyStepSum {
    public static void main(String[] args) {
        int [] nums = {-3,2,-3,4,2};
        System.out.println(minStartValue(nums));
    }
    public static int minStartValue(int[] nums) {
        int n = nums.length;
        int total = 0;
        int minimumEle = 0;
        for(int i = 0; i < nums.length; i++) {
            total+=nums[i];
            minimumEle = Math.min(minimumEle,total);
        }
        return 1-minimumEle;
    }

}
