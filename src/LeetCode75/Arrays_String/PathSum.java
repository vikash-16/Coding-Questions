package LeetCode75.Arrays_String;

import DSAPractice.Tree.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        String[] s = "10,5,-3,3,2,null,11,3,-2,null,1".split(",");
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode = binaryTree.constructBinaryTree(s);
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.pathSum(treeNode,8));
    }
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        pathSumHelper(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return count;
    }
    public void pathSumHelper(TreeNode root, int targetSum) {
        if(root == null) return;
        if(targetSum == root.val) {
            count++;
        }
        pathSumHelper(root.left,targetSum-root.val);
        pathSumHelper(root.right,targetSum-root.val);
    }

}
