package DSAPractice.Tree;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(root));
    }
    int minDepth;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        return (leftHeight == 0 || rightHeight == 0) ? leftHeight+rightHeight+1 : Math.max(leftHeight,rightHeight)+1;
    }
}
