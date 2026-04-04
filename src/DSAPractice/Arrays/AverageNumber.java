package DSAPractice.Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AverageNumber {
    public static void main(String[] args) {
        int [] nums = {1,2,4,7,10};
        System.out.println(new AverageNumber().averageValue(nums));
    }
    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for(int num : nums) {
            if(num % 2 == 0 && num % 3 == 0) {
                sum+=num;
                count++;
            }
        }
        return (int)sum/count;
    }
}
