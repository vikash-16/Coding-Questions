package DSAPractice.Tree;

public class PathSumIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);
        int targetSum = 0;
        System.out.println(new PathSumIII().pathSum(root,targetSum));
    }
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        helper(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return count;
    }

    private void helper(TreeNode root, long targetSum) {
        if(root == null) return;
        if(root.val == targetSum){
            count++;
        }
        helper(root.left,targetSum-root.val);
        helper(root.right,targetSum-root.val);
    }

}
