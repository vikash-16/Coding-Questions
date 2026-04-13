package LeetCode75.Arrays_String;

import DSAPractice.Tree.TreeNode;

public class DeleteNodeBST {
    public static void main(String[] args) {

    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val > key) {
            TreeNode leftNode = deleteNode(root.left, key);
        }else if(root.val < key) {
            TreeNode rightNode = deleteNode(root.right, key);
        }else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right,min.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
