package DSAPractice.Tree;

public class ConstructFromPrePost {
    public static void main(String[] args) {
       int [] preorder = {1,2,4,5,3,6,7}, postorder = {4,5,2,6,7,3,1};
        ConstructFromPrePost constructFromPrePost = new ConstructFromPrePost();
        constructFromPrePost.constructFromPrePost(preorder, postorder);
    }
    int preIndex = 0, postIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if(postorder[postIndex] != root.val) root.left = constructFromPrePost(preorder, postorder);
        if(postorder[postIndex] != root.val) root.right = constructFromPrePost(preorder, postorder);
        postIndex++;
        return root;
    }
}
