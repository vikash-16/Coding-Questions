package DSAPractice.Arrays;

public class GlobalAndLocalInversion {
    public static void main(String[] args) {
        int [] nums = {1,0,2};
        System.out.println(new GlobalAndLocalInversion().isIdealPermutation(nums));
    }
    public boolean isIdealPermutation(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(Math.abs(i-nums[i]) > 1) {
                return false;
            }
        }
        return true;
    }
}
