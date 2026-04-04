Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.



solution::

class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n==1) {
            return 0;
        }
        int max_pos = nums[0];
        int pos = nums[0];
        int jump = 1;
        for(int i = 1; i < n-1; i++) {
            max_pos = max(max_pos, i+ nums[i]);
            pos--;
            if(pos < 0) {
                return -1;
            }
            if(pos == 0) {
                jump++;
                pos = max_pos - i;
            }
        }
        if(max_pos >= n-1) {
            return jump;
        }
        return -1;
    }
};
