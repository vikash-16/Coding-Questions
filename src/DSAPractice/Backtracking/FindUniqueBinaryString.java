package DSAPractice.Backtracking;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
    public static void main(String[] args) {
        String [] nums = {"111","011","001"};
        System.out.println(new FindUniqueBinaryString().findDifferentBinaryString(nums));
    }
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            str.append(nums[i].charAt(i) == '0' ? '1':'0');
        }
        return str.toString();
    }
}