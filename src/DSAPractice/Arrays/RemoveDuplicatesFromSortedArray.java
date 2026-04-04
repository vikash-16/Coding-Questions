package DSAPractice.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));

    }
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] != nums[i+1]) {
                nums[idx++] = nums[i];
            }
        }
        nums[idx++] = nums[nums.length-1];
        return idx;
    }
}
