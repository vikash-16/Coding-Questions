package DSAPractice.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarraysDistinctElementSumofSquaresI {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 1);
        System.out.println(new SubarraysDistinctElementSumofSquaresI().sumCounts(nums));
    }
    public int sumCounts(List<Integer> nums) {
        int result = 0;
        for(int i = 0; i < nums.size(); i++) {
            Set<Integer> dict = new HashSet<>();
            for(int j = i; j < nums.size() ; j++) {
                dict.add(nums.get(j));
                result+= dict.size()*dict.size();
            }
        }
        return result;
    }
}
