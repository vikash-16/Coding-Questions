package Interview.BU;

import DSAPractice.Tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {
        String string = "1,2,3,null,null,4,5";
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode = binaryTree.BuildBinaryTree(string);
        StringBuilder s = new StringBuilder();
        binaryTree.PrintBinaryTree(treeNode,s);
        System.out.println(s.substring(0,string.length()-2));
    }
    public TreeNode BuildBinaryTree(String s){
        String[] values = s.split(",");
        List<String> list = Arrays.asList(values);
        Queue<String> queue = new LinkedList<>(list);
        return binaryTreeHelper(queue);
    }

    private TreeNode binaryTreeHelper(Queue<String> list) {
        if(list.isEmpty()){
            return null;
        }
        String val = list.poll();
        if(val != null && val.equals("null")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(val));
        treeNode.left = binaryTreeHelper(list);
        treeNode.right = binaryTreeHelper(list);
        return treeNode;
    }

    public void PrintBinaryTree(TreeNode root, StringBuilder s) {
        if(root == null) {
            s.append("null");
            return;
        }
        s.append(root.val);
        s.append(",");
        PrintBinaryTree(root.left,s);
        PrintBinaryTree(root.right,s);
    }
}
