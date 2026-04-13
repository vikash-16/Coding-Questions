package LeetCode75.Arrays_String;

import DSAPractice.Tree.TreeNode;
import com.sun.source.tree.Tree;

public class SearchBST {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode = binaryTree.constructBinaryTree("4,2,7,1,3".split(","));
        TreeNode treeNode1 = new SearchBST().searchBST(treeNode, 2);
        binaryTree.printBinaryTree(treeNode1);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        else if(root.val > val) return searchBST(root.left,val);
        return searchBST(root.right,val);
    }
}
