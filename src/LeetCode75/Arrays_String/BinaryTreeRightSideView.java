package LeetCode75.Arrays_String;

import DSAPractice.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        List<Integer> integers = new BinaryTreeRightSideView().rightSideView(new BinaryTree().constructBinaryTree("1,2,3,null,5,null,4".split(",")));
        System.out.println(integers);
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode>queue = new ArrayDeque<>();
        List<Integer>result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                if(i == size-1) result.add(node.val);
            }
        }
        return result;
    }
}
