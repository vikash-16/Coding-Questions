package DSAPractice.Arrays;

import java.util.*;

public class RestoretheArrayFromAdjacentPairs {
    public static void main(String[] args) {
        int [][]adjacentPairs = {{2,1},{3,4},{3,2}};
        System.out.println(Arrays.toString(new RestoretheArrayFromAdjacentPairs().restoreArray(adjacentPairs)));
    }
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int [] node: adjacentPairs) {
            int p1 = node[0];
            int p2 = node[1];
            if(!graph.containsKey(p1)) {
                graph.put(p1,new ArrayList<>());
            }
            if(!graph.containsKey(p2)) {
                graph.put(p2,new ArrayList<>());
            }
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }
        int rootNode = 0;
        for(Integer key : graph.keySet()) {
            if(graph.get(key).size() == 1) {
                rootNode = key;
                break;
            }
        }
        int [] result = new int[graph.size()];
        helper(rootNode,Integer.MAX_VALUE,result,0,graph);
        return result;
    }

    private void helper(int rootNode, int prev, int[] result, int i, Map<Integer, List<Integer>> graph) {
        result[i] = rootNode;
        for(Integer neighbour : graph.get(rootNode)) {
            if(neighbour != prev) {
                helper(neighbour,rootNode,result,i+1,graph);
            }
        }
    }
}
