package LeetCode75.Arrays_String;

import DSAPractice.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {
        String nodes = "3,9,20,null,null,15,7";
        String[] split = nodes.split(",");
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode = binaryTree.constructBinaryTree(split);
        binaryTree.printBinaryTree(treeNode);
    }

    public  void printBinaryTree(TreeNode root) {
        if(root == null) {
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    public TreeNode constructBinaryTree(String[] split) {
        if(split.length == 0 || split[0] == null) {
            return null;
        }
        Queue<TreeNode>queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int i = 1;
        while (i < split.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!split[i].equalsIgnoreCase("null")) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(split[i]));
                node.left = treeNode;
                queue.add(node.left);
            }
            i++;
            if(!split[i].equalsIgnoreCase("null")) {
                node.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
