package DSAPractice.Arrays;

public class MinimumSumofMountainTripletsI {
    public static void main(String[] args) {
        int []nums = {8,6,1,5,3};
        System.out.println(new MinimumSumofMountainTripletsI().minimumSum(nums));
    }
    public int minimumSum(int[] nums) {
        int []rightSmaller = new int[nums.length];
        int ans = -1;
        rightSmaller[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--) {
            rightSmaller[i] = Math.min(rightSmaller[i+1],nums[i]);
        }
        int leftSmaller = nums[0];
        for(int i = 1; i < nums.length-1; i++) {
            leftSmaller = Math.min(leftSmaller,nums[i-1]);
            if(leftSmaller <= nums[i] && rightSmaller[i] <= nums[i]) {
                if(ans == -1) {
                    ans = leftSmaller+nums[i]+rightSmaller[i];
                }
                ans = Math.min(ans,leftSmaller+nums[i]+rightSmaller[i]);
            }
        }
        return ans;
    }
}
