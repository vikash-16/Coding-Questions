package LeetCode75.Arrays_String;

import DSAPractice.Tree.TreeNode;

import java.util.*;

public class MaxLevelSum {
    public static void main(String[] args) {
        System.out.println(new MaxLevelSum().maxLevelSumDFS(
                new BinaryTree().constructBinaryTree("989,null,10250,98693,-89388,null,null,null,-32127".split(","))
        ));
    }
    /*Note: BFS Solution*/
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>queue = new ArrayDeque<>();
        long maxLevelSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int currLevel = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long currLevelSum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currLevelSum+=node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(currLevelSum > maxLevelSum) {
                maxLevelSum = currLevelSum;
                maxLevel = currLevel;
            }
            currLevel++;
        }
        return maxLevel;
    }

    /*Note: DFS Solution*/
    Map<Integer,Long>mp;
    public int maxLevelSumDFS(TreeNode root) {
        mp = new HashMap<>();
        int maxLevelSum = Integer.MIN_VALUE;
        int maxlevel = 0;
        if(root == null) return 0;
        maxLevelSumDFSHelper(root,1,mp);
        Integer i = mp.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
        return i;
    }

    private void maxLevelSumDFSHelper(TreeNode root, int currLevel, Map<Integer, Long> mp) {
        if(root == null) return;
        Long curSum = mp.getOrDefault(currLevel, (long)0);
        mp.put(currLevel,(long)curSum+root.val);
        maxLevelSumDFSHelper(root.left,currLevel+1,mp);
        maxLevelSumDFSHelper(root.right,currLevel+1,mp);
    }
}
