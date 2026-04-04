package DSAPractice.Arrays;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
       int [] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(new RearrangeArrayElementsBySign().rearrangeArray(nums)));
    }
    public int[] rearrangeArray(int[] nums) {
        int[] negative = Arrays.stream(nums).filter(i -> i < 0).toArray();
        int[] positive = Arrays.stream(nums).filter(i -> i > 0).toArray();
        int i = 0;
        int indx1 = 0,indx2 = 0;
        while (i < nums.length) {
            if(i%2 == 0) {
                nums[i++] = positive[indx1++];
            }else {
                nums[i++] = negative[indx2++];
            }
        }
        return nums;
    }
}
