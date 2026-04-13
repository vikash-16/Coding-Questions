package LeetCode75.Arrays_String;

import DSAPractice.Tree.TreeNode;

public class GoodNodes {
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root,Integer.MIN_VALUE);
    }
    public int goodNodesHelper(TreeNode root, int maxSofar) {
        if(root == null) return 0;
        int left = goodNodesHelper(root.left, Math.max(maxSofar,root.val));
        int right = goodNodesHelper(root.right, Math.max(maxSofar,root.val));
        int goodNodes = left+right;
        if(maxSofar <= root.val) {
            goodNodes++;
        }
        return goodNodes;
    }

}
