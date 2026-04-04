package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ApplyOperation {
    public static void main(String[] args) {
        Arrays.stream(new ApplyOperation().applyOperations(new int[]{1,2,2,1,1,0})).forEach(System.out::println);
    }
    //1,4,0,2,0,0
    public int[] applyOperations(int[] nums) {
        int []result = new int [nums.length];
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                result[index++] = nums[i-1]+nums[i];
            }
        }
        /*int left = 0,right = 0;
        while(left < nums.length && right < nums.length){
            while(left < nums.length && nums[left] != 0){
                left++;
            }
            right = left+1;
            while(right < nums.length && nums[right] == 0){
                right++;
            }
            if(right < nums.length && left != right && nums[left] == 0 && nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            left++;
        }*/
        return result;
    }
}
