package DSAPractice.Tree;

public class MaximumDifferenceBetweenNodeandAncestor {
    public static void main(String[] args) {

    }
    int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        diffCalculateHelper(root,min,max);
        return maxDiff;
    }

    private void diffCalculateHelper(TreeNode root, int min, int max) {
        if(root == null) return;
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);
        maxDiff = Math.max(maxDiff,max-min);
        diffCalculateHelper(root.left,min,max);
        diffCalculateHelper(root.right,min,max);
    }
}
