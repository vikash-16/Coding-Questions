package LeetCode75.Arrays_String;

import DSAPractice.Tree.TreeNode;

public class LeafSimilar {
    public static void main(String[] args) {
        String[] nodes1 = "3,5,1,6,2,9,8,null,null,7,4".split(",");
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root1 = binaryTree.constructBinaryTree(nodes1);
        String[] nodes2 = "3,5,1,6,7,4,2,null,null,null,null,null,null,9,8".split(",");
        TreeNode root2 = binaryTree.constructBinaryTree(nodes2);
        System.out.println(new LeafSimilar().leafSimilar(root1,root2));
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String root1LeafNodes = getLeafNodesOfTree(root1);
        System.out.println(root1LeafNodes);
        String root2leafNodes = getLeafNodesOfTree(root2);
        System.out.println(root2leafNodes);
        return root1LeafNodes.equalsIgnoreCase(root2leafNodes);
    }

    private String getLeafNodesOfTree(TreeNode root) {
        if(root.left == null && root.right == null) {
            return (String.valueOf(root.val))+" ";
        }
        StringBuilder s = new StringBuilder();
        if(root.left != null) {
            s.append(getLeafNodesOfTree(root.left));
        }
        if(root.right != null) {
            s.append(getLeafNodesOfTree(root.right));
        }
        return s.toString();
    }
}
