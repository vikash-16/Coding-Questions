package DSAPractice.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsinanArray {
    public static void main(String[] args) {
        int [] nums = {1,2};
        int [][]operation = {{1,3},{2,1},{3,2}};
        System.out.println(Arrays.toString(new ReplaceElementsinanArray().arrayChange(nums,operation)));
    }
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer>dict = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            dict.put(nums[i],i);
        }
        for(int [] op : operations) {
            Integer ind = dict.get(op[0]);
            nums[dict.get(op[0])] = op[1];
            dict.remove(op[0]);
            dict.put(op[1],ind);

        }
        return nums;
    }
}
