package DSAPractice.Arrays;

import DSAPractice.Tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

public class ConstructBSTFromPreOrder {
    public static void main(String[] args) {
        int [] preorder = {8,5,1,7,10,12};
        TreeNode treeNode = bstFromPreorder(preorder);


    }
    static int index = 0;
    public static TreeNode bstFromPreorder(int[] preorder) {
        int [] inorder = preorder.clone();
        Arrays.sort(inorder);
        HashMap<Integer, Integer> dict = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            dict.put(inorder[i],i);
        }

        return bstFromPreorderUtil(preorder,inorder,0,inorder.length-1,dict);
    }

    private static TreeNode bstFromPreorderUtil(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> dict) {
        if(left > right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[index]);
        index++;
        if(left == right) {
            return treeNode;
        }
        int m = dict.get(treeNode.val);
        treeNode.left = bstFromPreorderUtil(preorder,inorder,left,m-1,dict);
        treeNode.right = bstFromPreorderUtil(preorder,inorder,m+1,right,dict);
        return treeNode;
    }
}
