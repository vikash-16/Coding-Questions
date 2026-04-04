package DSAPractice.Tree;

import java.util.ArrayList;

public class LeafSimilarTrees {
    public static void main(String[] args) {

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder str1 = new StringBuilder();
        helper(root1,str1);
        StringBuilder str2 = new StringBuilder();
        helper(root2,str2);
        return str1.toString().equalsIgnoreCase(str2.toString());
    }

    private void helper(TreeNode root, StringBuilder str) {
        if(root == null) return;
        if(root.left == null && root.right == null) str.append(root.val+" ");
        helper(root.left,str);
        helper(root.right,str);
    }
}
