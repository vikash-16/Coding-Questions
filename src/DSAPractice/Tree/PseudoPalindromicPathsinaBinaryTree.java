package DSAPractice.Tree;


public class PseudoPalindromicPathsinaBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(1);
        System.out.println(new PseudoPalindromicPathsinaBinaryTree().pseudoPalindromicPaths(treeNode));

    }
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null) return 0;
        int [] freq = new int[10];
        pseudoPalindromicPathsHelper(root,freq);
        return count;
    }

    private void pseudoPalindromicPathsHelper(TreeNode root, int[] path) {
        if(root == null) return;
        path[root.val]++;
        if(root.left == null && root.right == null) {
            count+=checkIsPalindrome(path);
        }
        pseudoPalindromicPathsHelper(root.left,path);
        pseudoPalindromicPathsHelper(root.right,path);
        path[root.val]--;
    }

    private int checkIsPalindrome(int[] path) {
        int miss = 0;
        for(int i=0;i<=9;i++){
            if(path[i] % 2 != 0)
                miss++;
            if(miss > 1)
                return 0;
        }
        return 1;
    }
}
