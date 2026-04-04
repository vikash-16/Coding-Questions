package DSAPractice.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class EvenOddTree {
    public static void main(String[] args) {
        /*[1,10,4,3,null,7,9,12,8,6,null,null,2]*/
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(10);
        treeNode.right = new TreeNode(4);
        treeNode.left.left = new TreeNode(3);
//        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(9);
        System.out.println(new EvenOddTree().isEvenOddTree(treeNode));
        treeNode.left.left.left = new TreeNode(12);
        treeNode.left.left.right = new TreeNode(8);
        treeNode.right.left.left = new TreeNode(6);
        treeNode.right.right.right = new TreeNode(2);
    }
    public boolean isEvenOddTree(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<TreeNode> levelNodes = new ArrayList<>(queue);
            if(level % 2 == 0) {        //even level
                if(levelNodes.get(0).val % 2 == 0) return false;
                for(int i = 1; i < n; i++) {
                    if(levelNodes.get(i).val % 2 == 0 || levelNodes.get(i).val <= levelNodes.get(i-1).val) {
                        return false;
                    }
                }
            }else {
                if(levelNodes.get(0).val % 2 != 0) return false;
                for(int i = 1; i < n; i++) {
                    if(levelNodes.get(i).val % 2 != 0 || levelNodes.get(i).val >= levelNodes.get(i-1).val) {
                        return false;
                    }
                }
            }
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.pop();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            level++;
        }
        return true;
    }
}
