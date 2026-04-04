Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42


solution::

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int solution(TreeNode *root, int &max_sum) {
        if(!root) {
            return 0;
        }
        int left = solution(root->left, max_sum);
        int right = solution(root->right, max_sum);
        int temp = max(max(left,right)+root->val, root->val);
        int ans = max(temp, left+right+root->val);
        max_sum = max(max_sum, ans);
        return temp;
    }
    int maxPathSum(TreeNode* root) {
        int max_sum = INT_MIN;
        solution(root, max_sum);
        return max_sum;
    }
};
