package LeetCode_Crash_Course;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {
        int []nums = {0,0,0};
        System.out.println(new MajorityElement().majorityElement(nums));

    }
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = Integer.MAX_VALUE, candidate2 = Integer.MAX_VALUE, votes1 = 0, votes2 = 0;
        List<Integer>result = new ArrayList<>();
        for(int num : nums) {
            if(votes1 == 0 && num != candidate2) {votes1 = 1;candidate1 = num;}
            else if(votes2 == 0 && num != candidate1) {votes2 = 1; candidate2 = num;}
            else if(candidate1 == num) votes1++;
            else if(candidate2 == num) votes2++;
            else {votes1--;votes2--;}
        }
        votes1 = 0;votes2 = 0;
        for(int num : nums) {
            if(num == candidate1) votes1++;
            if(num == candidate2) votes2++;
        }
        if(votes1 > nums.length/3) result.add(candidate1);
        if(votes2 > nums.length/3) result.add(candidate2);
        return result;
    }
}
