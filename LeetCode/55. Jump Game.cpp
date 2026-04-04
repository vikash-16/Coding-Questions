Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 3 * 10^4
0 <= nums[i][j] <= 10^5


solution::

class Solution {
public:
    bool jumpos(long int pos , vector<int>&dp, vector<int>&nums) {
        if(dp[pos] != -1) {
            if(dp[pos] == 1) {
                return true;
            }else{
                return false;
            }
        }
        long int jump_positions = 0;
        if(pos+nums[pos] < nums.size()-1) {
            jump_positions = pos+nums[pos];
        }else {
            jump_positions = nums.size()-1;
        }
        for(long int next_pos = pos+1; next_pos <= jump_positions; next_pos++) {
            if(jumpos(next_pos, dp, nums) == true) {
                nums[pos] = 1;
                return true;
            }
        }
        nums[pos] = 0;
        return false;
    }
    bool canJump(vector<int>& nums) {
       long int n = nums.size();
        vector<int>dp(n,-1);
        dp[n-1] = 1;
        return jumpos(0,dp,nums);
    }
//      bool canJump(vector<int>& nums) {
//         if(nums.size()==1) return true;

//         int maxi=0;
//         int ci;

//         for(int i=0;i<nums.size()-1;i++)
//         {
//             ci=i+nums[i];
//             if(i>maxi) return false;
//             maxi=max(maxi,ci);
//             if(maxi>=nums.size()-1)
//                 return true;
//         }
//         return false;
//      }
};
