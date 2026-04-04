package DSAPractice.Tree;

import java.util.*;


public class FindModeInBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
//        treeNode.right = new TreeNode(2);
//        treeNode.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(new FindModeInBST().findMode(treeNode)));
    }
    int currEle = 0;
    int currFreq = 0,maxFreq = 0;
    List<Integer> ans = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorderTraversal(root);
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private void inorderTraversal(TreeNode root) {
        if(root == null)
            return;
        inorderTraversal(root.left);
        int num = root.val;
        if (num == currEle) {
            currFreq++;
        } else {
            currFreq = 1;
            currEle = num;
        }

        if (currFreq > maxFreq) {
            ans = new ArrayList();
            maxFreq = currEle;
        }

        if (currFreq == maxFreq) {
            ans.add(num);
        }
        inorderTraversal(root.right);
    }
    /** solution -1*/
/**
    public int[] findMode(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        Map<Integer,Integer>counter = new HashMap<>();
        preOrder(root,counter);
        int maxFreq = Integer.MIN_VALUE;
        for(Integer val : counter.values()) {
            maxFreq = Math.max(maxFreq,val);
        }
        for(Integer key : counter.keySet()) {
            if(counter.get(key) == maxFreq) {
                result.add(key);
            }
        }
        int[] array = result.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }

    private void preOrder(TreeNode root, Map<Integer, Integer> counter) {
        if(root == null) {
            return;
        }
        counter.put(root.val,counter.getOrDefault(root.val,0)+1);
        preOrder(root.left,counter);
        preOrder(root.right,counter);
    }
*/
}
