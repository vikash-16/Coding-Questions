package LeetCode_Crash_Course.Hashing;

import java.util.*;
/**
 * Given a 2D array nums that contains n arrays of distinct integers, return a sorted array containing all the numbers that appear in all n arrays.
 *
 * For example, given nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]], return [3, 4]. 3 and 4 are the only numbers that are in all arrays.
 * */
public class IntersectionofMultipleArrays {
    public static void main(String[] args) {
        int [][] nums = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        List<Integer> intersection = intersection(nums);
        System.out.println(intersection);
    }
    public static List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        HashMap<Integer,Integer>counts = new HashMap<>();
        List<Integer>result = new ArrayList<>();
        for(int [] arr: nums) {
            for(int x : arr) {
                counts.put(x,counts.getOrDefault(x,0)+1);
            }
        }
        for(Integer key : counts.keySet()) {
            if(counts.get(key) == n) {
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }
    }
