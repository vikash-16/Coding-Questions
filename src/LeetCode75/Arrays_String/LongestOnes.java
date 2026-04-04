package LeetCode75.Arrays_String;

public class LongestOnes {
    public static void main(String[] args) {
        int i = new LongestOnes().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        System.out.println(i);
    }

    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int maxlen = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            if(nums[j] == 0) zeroCount++;
            if(zeroCount > k) {
                if(nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }
            if (zeroCount <= k) maxlen = Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;
    }
}
