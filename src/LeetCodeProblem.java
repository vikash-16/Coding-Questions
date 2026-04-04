import DSAPractice.Tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LeetCodeProblem {
    public static void main(String[] args) {
        LeetCodeProblem lc = new LeetCodeProblem();
        String traversal = "1-401--349---90--88";
        TreeNode treeNode = lc.recoverFromPreorder(traversal);
        System.out.println(traversal);

    }
    public TreeNode recoverFromPreorder(String traversal) {
        int i = 0,val = 0,temp = 1;
        while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
            val = (val*10)+traversal.charAt(i)-'0';
            i++;
        }
        TreeNode root = new TreeNode(traversal.charAt(0)-'0');
        Map<Integer, LinkedList<TreeNode>> levelMap = new HashMap<Integer, LinkedList<TreeNode>>();
        levelMap.putIfAbsent(0, new LinkedList<>());
        levelMap.get(0).addLast(root);
        while (i < traversal.length()) {
            int depth = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }
            if(depth > 0) {
                val = 0;
                temp = 1;
                while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                    val = (val*10)+traversal.charAt(i)-'0';
                    i++;
                }
                TreeNode treeNode = new TreeNode(val);
                levelMap.putIfAbsent(depth, new LinkedList<>());
                levelMap.get(depth).addLast(treeNode);
                TreeNode parentNode = levelMap.get(depth - 1).getLast();
                if(parentNode.left == null) parentNode.left = treeNode;
                else if(parentNode.right == null) parentNode.right = treeNode;
            }
        }
        return root;
    }
}
