package DSAPractice.Tree;

import java.util.*;

public class DeepestLeavesSum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        System.out.println(deepestLeavesSum(treeNode));

    }
    public static int deepestLeavesSum(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, List<Integer>> levelOrder = new HashMap<>();
        queue.add(root);
        Integer level = 0;
        levelOrder.put(level,Arrays.asList(root.val));
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> levelEle = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                levelEle.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                levelOrder.put(level,levelEle);
            }
            level++;
        }
        List<Integer> integers = levelOrder.get(level-1);
        for(Integer a: integers) {
            res+=a;
        }
        return res;
    }
}
