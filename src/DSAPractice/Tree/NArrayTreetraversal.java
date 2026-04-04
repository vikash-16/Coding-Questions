package DSAPractice.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NArrayTreetraversal {
    public static void main(String[] args) {
        Node root = new Node();
        System.out.println(new NArrayTreetraversal().levelOrder(root).toString());
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>result = new ArrayList<>();
        if(root == null) return new ArrayList<>();
        Queue<Node>queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer>temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                Node node = queue.poll();
                temp.add(node.val);
                if(node.children != null) {
                    for (Node child : node.children) {
                        queue.add(child);
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }
}
