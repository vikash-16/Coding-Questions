package DSAPractice.Graph;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 4;
        int [][]flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(n,flights,src,dst,k));
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, cost});
        }

        // BFS
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{src, 0});
        distance[src] = 0;

        int steps = 0;

        while (!queue.isEmpty() && steps <= k) {
            int size = queue.size();
            while (size-- > 0) {
                int[] node = queue.poll();
                int u = node[0];
                int p = node[1];

                for (int[] edge : adj.getOrDefault(u, new ArrayList<>())) {
                    int v = edge[0];
                    int cost = edge[1];

                    if (distance[v] > p + cost) {
                        distance[v] = p + cost;
                        queue.offer(new int[]{v, p + cost});
                    }
                }
            }
            steps++;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
