package LeetCode75.Arrays_String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifference {
    public static void main(String[] args) {
        System.out.println(new FindDifference().findDifference(new int[]{1,2,3},new int[]{2,4,6}));
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer>s2 = new HashSet<>();
        List<List<Integer>>result = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++) {
            s2.add(nums2[i]);
        }
        List<Integer>temp1 = new ArrayList<>();
        for(Integer n: s1) {
            if(!s2.contains(n)) {
                temp1.add(n);
            }
        }
        result.add(temp1);
        List<Integer>temp2 = new ArrayList<>();
        for(Integer n: s2) {
            if(!s1.contains(n)) {
                temp2.add(n);
            }
        }
        result.add(temp2);
        return result;
    }
}
