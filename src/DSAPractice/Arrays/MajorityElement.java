package DSAPractice.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        int votes = 0, candidate = -1;
        for(int i = 0; i < nums.length; i++) {
            if(votes == 0) {
                candidate = nums[i];
                votes = 1;
            }else if(nums[i] == candidate) {
                votes++;
            }else {
                votes--;
            }
        }
        votes = 0;
        for(int num : nums) {
            if(num == candidate) {
                votes++;
            }
        }
        return (nums.length/2) < votes ? candidate : -1;
    }
}
