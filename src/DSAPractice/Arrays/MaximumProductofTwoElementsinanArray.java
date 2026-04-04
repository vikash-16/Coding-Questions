package DSAPractice.Arrays;

public class MaximumProductofTwoElementsinanArray {
    public static void main(String[] args) {
        int [] nums = {1,5,4,5};
        System.out.println(new MaximumProductofTwoElementsinanArray().maxProduct(nums));
    }
    public int maxProduct(int[] nums) {
        int firstMax = Math.max(nums[0],nums[1]),secondMax = Math.min(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++) {
            if(firstMax < nums[i]) {
                if(secondMax < firstMax) {
                    secondMax = firstMax;
                    firstMax = nums[i];
                }else {
                    firstMax = nums[i];
                }
            }else {
                if(secondMax < nums[i]) {
                    secondMax = nums[i];
                }
            }
        }
        return (firstMax-1)*(secondMax-1);
    }

}
