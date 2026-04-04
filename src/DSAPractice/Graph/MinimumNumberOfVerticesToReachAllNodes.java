package DSAPractice.Graph;

import java.lang.reflect.Array;
import java.util.*;

public class MinimumNumberOfVerticesToReachAllNodes {
    public static void main(String[] args) {
       int n = 6;
       List<List<Integer>> edges = new ArrayList<>(Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(0,2),
                Arrays.asList(2,5),
                Arrays.asList(3,4),
                Arrays.asList(4,2)
        ));
        System.out.println(findSmallestSetOfVertices(n,edges).toString());
    }
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer>nodes = new HashSet<>();
        Set<Integer>result = new HashSet<>();
        for(var edge: edges) {
            nodes.add(edge.get(1));
        }
        for(var node : edges) {
            if(!nodes.contains(node.get(0))) {
                result.add(node.get(0));
            }
        }
        return new ArrayList<>(result);
    }
}
