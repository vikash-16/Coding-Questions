package DSAPractice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfSubSequence {
    public static void main(String[] args) {
        int[]nums ={14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
        System.out.println(numSubseq(nums,22));
    }
    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        int count = 0;
        while(left <= right) {
            if(nums[left]+nums[right] <= target) {
                count+=Math.pow(2,right-left)%(1e9+7);
                left++;
            }else {
                right--;
            }
        }
        return (int) (count%(1e9+7));
    }
}
