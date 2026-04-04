package DSAPractice;

import java.net.URLEncoder;

public class JumpGame {
    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        System.out.println(nums);
    }
    public static boolean canJump(int[] nums) {
        int currInd = 0,maxInd = 0;
        for(int i = 0; i < nums.length; i++) {
            currInd = i+nums[i];
            if(i > maxInd) {
                return false;
            }
            maxInd = Math.max(maxInd,currInd);
            if(maxInd >= nums.length-1) {
                return true;
            }
        }
        return false;
    }
}
