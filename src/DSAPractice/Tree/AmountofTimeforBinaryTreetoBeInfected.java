package DSAPractice.Tree;

import java.util.*;

public class AmountofTimeforBinaryTreetoBeInfected {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        System.out.println(new AmountofTimeforBinaryTreetoBeInfected().amountOfTime(root,3));
    }
    public int amountOfTime(TreeNode root, int start) {
        getGrapph(root);
        if(graph.size() == 0) return 0;
        System.out.println(graph);
        Queue<Integer>queue = new ArrayDeque<>();
        Set<Integer>seen = new HashSet<>();
        queue.add(start);
//        seen.add(start);
        int dist = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                Integer node = queue.poll();
                if(seen.contains(node)) continue;
                seen.add(node);
                List<Integer> adjacentNode = graph.get(node);
                for(int j = 0; j < adjacentNode.size(); j++) {
                    if(!seen.contains(adjacentNode.get(j))) {
                        queue.add(adjacentNode.get(j));
//                        seen.add(adjacentNode.get(j));
                    }
                }

            }
            dist++;
        }
        return dist-1;
    }
    Map<Integer, List<Integer>>graph = new HashMap<>();
    private void getGrapph(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;
        if(root.left != null) {
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
            graph.computeIfAbsent(root.left.val, k->new ArrayList<>()).add(root.val);
            getGrapph(root.left);
        }
        if(root.right != null) {
            graph.computeIfAbsent(root.val,k->new ArrayList<>()).add(root.right.val);
            graph.computeIfAbsent(root.right.val, k->new ArrayList<>()).add(root.val);
            getGrapph(root.right);
        }
    }
}
