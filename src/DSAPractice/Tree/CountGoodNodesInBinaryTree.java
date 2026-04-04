package DSAPractice.Tree;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(new CountGoodNodesInBinaryTree().goodNodes(root));
    }
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root,Integer.MIN_VALUE);
    }

    private int goodNodesHelper(TreeNode root, int maxSoFar) {
        if(root == null) {
            return 0;
        }
        int left = goodNodesHelper(root.left, Math.max(root.val, maxSoFar));
        int right = goodNodesHelper(root.right, Math.max(root.val, maxSoFar));
        int ans = left+right;
        if(root.val >= maxSoFar) {
            ans++;
        }
        return ans;
    }
}
