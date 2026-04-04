package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.List;

/*You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b


Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"


Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.
*/

public class SummaryRanges_228 {
    public static void main(String[] args) {
        int []nums = {0,2,3,4,6,8,9,10,12,13,14,18,20,22};
        List<String> result = summaryRanges(nums);
        System.out.println(result);
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String>result = new ArrayList<>();
        if(nums.length == 0) return new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1]+1 == nums[i]) {
                end = i;
            }else {
                if(start != end) {
                    result.add(nums[start]+"->"+nums[end]);
                }else {
                    result.add(String.valueOf(nums[start]));
                }
                start = end = i;
            }
        }
        if(start != end) {
            result.add(nums[start]+"->"+nums[end]);
        }else {
            result.add(String.valueOf(nums[start]));
        }
        return result;
    }
}
