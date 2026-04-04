package DSAPractice.BitManiPulation;

import java.util.ArrayList;
import java.util.List;

public class SumofValuesatIndicesWithKSetBits {
    public static void main(String[] args) {
        List<Integer>nums = new ArrayList<>(List.of(5,10,1,5,2));
        int k = 1;
        System.out.println(new SumofValuesatIndicesWithKSetBits().sumIndicesWithKSetBits(nums,k));
    }
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(Integer.bitCount(i) == k) {
                sum+=nums.get(i);
            }
        }
        return sum;
    }
}
