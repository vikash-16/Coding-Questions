package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertAnArrayIntoA2DArrayWithConditions {
    public static void main(String[] args) {
        int []nums = {1,3,4,1,2,3,1};
        System.out.println(new ConvertAnArrayIntoA2DArrayWithConditions().findMatrix(nums));
    }
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer,Integer> dict = new HashMap<>();
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            dict.put(nums[i],dict.getOrDefault(nums[i],0)+1);
            maxCount = Math.max(maxCount,dict.get(nums[i]));
        }
        List<List<Integer>>result = new ArrayList<>();
        while (maxCount > 0) {
            List<Integer>temp = new ArrayList<>();
            for(Integer key : dict.keySet()) {
                if(dict.get(key) > 0) {
                    temp.add(key);
                    dict.put(key,dict.get(key)-1);
                }
            }
            result.add(temp);
            maxCount--;
        }
        return result;
    }
}
