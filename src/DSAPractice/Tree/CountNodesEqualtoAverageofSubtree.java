package DSAPractice.Tree;

public class CountNodesEqualtoAverageofSubtree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);
//        root.right.right.right = new TreeNode(3);
        System.out.println(new CountNodesEqualtoAverageofSubtree().averageOfSubtree(root));

    }
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        int[] ints = averageOfSubtreeHelper(root);
        return count;
    }

    private int [] averageOfSubtreeHelper(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        }
        int [] temp = new int[2];
        int[] leftAvg = averageOfSubtreeHelper(root.left);
        int[] rightAvg = averageOfSubtreeHelper(root.right);
        temp[0] = leftAvg[0]+rightAvg[0]+root.val;
        temp[1] = leftAvg[1]+rightAvg[1]+1;
        int totalAvg = (int)temp[0]/temp[1];
        if(totalAvg == root.val) {
            count++;
        }
        return temp;
    }
}
