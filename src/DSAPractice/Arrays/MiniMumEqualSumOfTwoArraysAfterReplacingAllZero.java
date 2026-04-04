package DSAPractice.Arrays;

public class MiniMumEqualSumOfTwoArraysAfterReplacingAllZero {
    public static void main(String[] args) {
        int [] nums1 = {20,0,18,11,0,0,0,0,0,0,17,28,0,11,10,0,0,15,29};
        int [] nums2 = {16,9,25,16,1,9,20,28,8,0,1,0,1,27};
        System.out.println(new MiniMumEqualSumOfTwoArraysAfterReplacingAllZero().minSum(nums1,nums2));
    }
    public long minSum(int[] nums1, int[] nums2) {
        long countZero1 = 0, sumOfNum1 = 0;
        long countZero2 = 0, sumOfNum2 = 0;
        for(int num : nums1) {
            sumOfNum1+=Math.max(num,1);
            if(num == 0) {
                countZero1++;
            }
        }
        for(int num : nums2) {
            sumOfNum2+=Math.max(num,1);
            if(num == 0) {
                countZero2++;
            }
        }
        if(countZero1 == 0 && sumOfNum1 < sumOfNum2) return -1;
        if(countZero2 == 0 && sumOfNum2 < sumOfNum1) return -1;
        return Math.max(sumOfNum1,sumOfNum2);

    }
}
