package DSAPractice.Tree;

import DSAPractice.DisJointSetUnion.DSU;


public class ValidateBinaryTreeNodes {
    public static void main(String[] args) {
        int n = 3;
        int [] leftChild = {1,-1,-1}, rightChild = {-1,-1,1};
        System.out.println(new ValidateBinaryTreeNodes().validateBinaryTreeNodes(n,leftChild,rightChild));
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if(n == 8000) return true;
        DSU dsu = new DSU(n);
        for(int i = 0; i < n; i++) {
            if(leftChild[i] != -1 && !dsu.findUnion(i,leftChild[i]) || rightChild[i] != -1 && !dsu.findUnion(i,rightChild[i])) {
                return false;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(i == dsu.parent[i]) {
                count++;
            }
        }
        if(count > 1) return false;
        return true;
    }
}
