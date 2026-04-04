package DSAPractice.Arrays;

import java.util.Arrays;

public class FindIndicesWithIndexandValueDifferenceII {
    public static void main(String[] args) {
        int []nums = {5,1,4,1};
        int indexDifference = 2, valueDifference = 4;
        System.out.println(Arrays.toString(new FindIndicesWithIndexandValueDifferenceII().findIndices(nums,indexDifference,valueDifference)));
    }
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int [] result = new int [2];
        result[0] = -1;
        result[1] = -1;
        int n = nums.length;
        for(int i = 0; i < n-indexDifference; i++) {
            for(int j = i+indexDifference; j < n; j++) {
                if(Math.abs(nums[i]-nums[j]) == valueDifference) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
