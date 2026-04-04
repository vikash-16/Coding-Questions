package DSAPractice.Arrays;

public class MonoTonicArray {
    public static void main(String[] args) {
        int [] nums = {1,1,1,2};
        System.out.println(new MonoTonicArray().isMonotonic(nums));
    }
    public boolean isMonotonic(int[] nums) {
        if(nums.length <= 1) {
            return true;
        }
        Boolean isAscending = nums[nums.length-1] - nums[0] > 0 ? true : false;
        for(int i = 1; i < nums.length; i++) {
            if(isAscending && nums[i-1] > nums[i]) {
                return false;
            }else if(!isAscending && nums[i-1] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
