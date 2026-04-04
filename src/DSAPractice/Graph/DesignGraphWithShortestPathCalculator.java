package DSAPractice.Graph;

import java.util.*;

public class DesignGraphWithShortestPathCalculator {
    public static void main(String[] args) {
        int n = 4;
        int [][]edges = {{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}};
        DesignGraphWithShortestPathCalculator designGraphWithShortestPathCalculator = new DesignGraphWithShortestPathCalculator();
        designGraphWithShortestPathCalculator.Graph(n,edges);
        System.out.println(designGraphWithShortestPathCalculator.shortestPath(3,2));
    }
    Map<Integer, List<int[]>> graph = new HashMap<>();
    public void Graph(int n, int[][] edges) {
        for(int [] edge : edges) {
            if(!graph.containsKey(edge[0])) {
                graph.put(edge[0],new ArrayList<>());
            }
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
    }

    public void addEdge(int[] edge) {
        if(!graph.containsKey(edge[0])) {
            graph.put(edge[0],new ArrayList<>());
        }
        graph.get(edge[0]).add(new int []{edge[1],edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, node1});
        Set<Integer> seen = new HashSet<>();
        while (!pq.isEmpty()) {
            int cost = pq.peek()[0], node = pq.poll()[1];
            if (node == node2) {
                return cost;
            }
            if (graph.containsKey(node) && seen.add(node)) {
                for(int [] edge:graph.get(node)) {
                    pq.offer(new int[]{edge[1]+cost,edge[0]});
                }
            }
        }
        return -1;
    }
}
