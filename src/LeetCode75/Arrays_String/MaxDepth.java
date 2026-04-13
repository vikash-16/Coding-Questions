package LeetCode75.Arrays_String;

import DSAPractice.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] args) {
        String string = "3,9,20,null,null,15,7";
        String[] split = string.split(",");
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode = binaryTree.constructBinaryTree(split);
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(treeNode));
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size;i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            depth++;
        }
        return depth;
        /*if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;*/
    }

}
