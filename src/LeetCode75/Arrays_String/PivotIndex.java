package LeetCode75.Arrays_String;

public class PivotIndex {
    public static void main(String[] args) {
        System.out.println(new PivotIndex().pivotIndex(new int[]{1,7,3,6,5,6}));
    }
    public int pivotIndex(int[] nums) {
        int tolalSum = 0;
        for(int n: nums) {
            tolalSum+=n;
        }
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(leftSum == (tolalSum-leftSum-nums[i])) {
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}
