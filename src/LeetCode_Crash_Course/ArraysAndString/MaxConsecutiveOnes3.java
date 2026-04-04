package LeetCode_Crash_Course.ArraysAndString;
/**Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        int [] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
        }
    public static int longestOnes(int[] nums, int k) {
        int left = 0, maxLength = 0;
        int countZero = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                countZero++;
            }
            while (countZero > k) {
                if(nums[left] == 0) {
                    countZero--;
                }
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
