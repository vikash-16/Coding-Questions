package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class SlidingSubArrayBeuty_Leetcode_2653 {
    public static void main(String[] args) {
        int [] nums = {-6,40,-38,-36,-36,-4,-38,-43,8};
        int[] subarrayBeauty = getSubarrayBeauty(nums, 2, 2);
        for(int x : subarrayBeauty) {
            System.out.println(x);
        }
    }
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int length = nums.length;
        int [] result = new int[length-k+1];
        TreeMap<Integer,Integer> freq = new TreeMap<>();
        for(int i = 0; i < k ; i++) {
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        result[0]= getMinInSubArray(freq, x);
        for(int i = k; i < length; i++) {
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            freq.put(nums[i-k],freq.getOrDefault(nums[i-k],0)-1);
            if(freq.get(nums[i-k]) == 0) {
                freq.remove(nums[i-k]);
            }
            result[i-k+1] = getMinInSubArray(freq,x);
        }
        return result;
    }

    private static int getMinInSubArray(TreeMap<Integer, Integer> freq, int x) {
        int smallest = 0;
        for(Integer val : freq.keySet()) {
            if(val < 0) {
                smallest+=freq.get(val);
            }else {
                return 0;
            }
            if(smallest >= x) {
                return val;
            }
        }
        return 0;
    }
}
