package LeetCode75.Arrays_String;

import DSAPractice.Tree.TreeNode;

public class LongestZigZag {
    public static void main(String[] args) {
        TreeNode root = new BinaryTree().constructBinaryTree("1,null,1,1,1,null,null,1,1,null,1,null,null,null,1".split(","));
        int i = new LongestZigZag().longestZigZag(root);
        System.out.println(i);
    }
    int maxSteps = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        longestZigZagHelper(root,true,0);
        longestZigZagHelper(root,false,0);
        return maxSteps;
    }

    private void longestZigZagHelper(TreeNode root, boolean isLeft, int steps) {
        if(root == null) return;
        maxSteps = Math.max(maxSteps,steps);
        if(isLeft) {
            longestZigZagHelper(root.right,false,steps+1);
            longestZigZagHelper(root.left,true,1);
        }else {
            longestZigZagHelper(root.right,true,steps+1);
            longestZigZagHelper(root.right,false,1);
        }
    }
}
