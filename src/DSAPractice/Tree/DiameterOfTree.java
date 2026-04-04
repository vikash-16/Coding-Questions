package DSAPractice.Tree;

public class DiameterOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new DiameterOfTree().diameterOfBinaryTree(root));
    }
    int maxCount = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxCount;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int leftCount = helper(root.left);
        int rightCount = helper(root.right);
        maxCount = Math.max(maxCount,leftCount+rightCount);
        return Math.max(leftCount,rightCount)+1;
    }
}
