package DSAPractice.Tree;

import DSAPractice.Arrays.TrappingRainWater;

public class ConstructStringFromBinaryString {
    public static void main(String[] args) {
        /*1(2(4))(3)"*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right =  new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(new ConstructStringFromBinaryString().tree2str(root));
    }
    StringBuilder str = new StringBuilder();
    public String tree2str(TreeNode root) {
        helper(root);
        return str.toString();
    }

    private void helper(TreeNode root) {
        if(root!=null){
            str.append(root.val);
            if(root.left!=null||root.right!=null){
                str.append("(");
                helper(root.left);
                str.append(")");
                if(root.right!=null){
                    str.append("(");
                    helper(root.right);
                    str.append(")");
                }
            }
        }
    }
}
