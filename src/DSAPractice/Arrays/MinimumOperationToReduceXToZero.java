package DSAPractice.Arrays;

public class MinimumOperationToReduceXToZero {
    public static void main(String[] args) {
        int []nums = {1,1,4,2,3};
        int x = 5;
        System.out.println(new MinimumOperationToReduceXToZero().minOperations(nums,x));
    }
    public int minOperations(int[] nums, int x) {
        int start = 0, end = nums.length-1;
        return minOperationsSolution(start,end,nums,x,0);
    }

    private int minOperationsSolution(int start, int end, int[] nums, int x, int count) {
        if(start > end) {
            return -1;
        }
        if(x == 0) return count;
        int left = minOperationsSolution(start + 1, end, nums, x - nums[start], count + 1);
        int right = minOperationsSolution(start, end - 1, nums, x - nums[end], count + 1);
        return Math.min(left,right);
    }
}
