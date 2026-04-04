package DSAPractice.Arrays;

import java.util.*;

public class MajorityElement2 {
    public static void main(String[] args) {
        int [] nums = {3,2,3};
        System.out.println(new MajorityElement2().majorityElement(nums).toString());
    }
    public List<Integer> majorityElement(int[] nums) {
//        HashMap<Integer,Integer>mp = new HashMap<>();
//        for(int num: nums) {
//            mp.put(num,mp.getOrDefault(num,0)+1);
//        }
//        List<Integer>result = new ArrayList<>();
//        mp.forEach((key,value)->{if(value > nums.length/3) {
//            result.add(key);
//        }
//        });
//        return result;
        int votes1 = 0,votes2 = 0, candidate1 = 0,candidate2 = 0;
        for(int num : nums) {
            if(votes1 == 0 && num != candidate2) {candidate1 = num;votes1 = 1;}
            else if(votes2 == 0 && num != candidate1) {candidate2 = num;votes2 = 1;}
            else if(candidate1 == num) votes1++;
            else if(candidate2 == num) votes2++;
            else {votes1--;votes2--;}
        }
        votes1 = 0;votes2 = 0;
        List<Integer>result = new ArrayList<>();
        for(int num: nums) {
            if(num == candidate1) {
                votes1++;
            }else if(num == candidate2) {
                votes2++;
            }
        }
        if(votes1 > nums.length/3) result.add(candidate1);
        if(votes2 > nums.length/3) result.add(candidate2);
        return result;
    }
}
