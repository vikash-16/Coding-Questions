package DSAPractice.Graph;

import java.util.*;

public class BusRoute {
    public static void main(String[] args) {
        int [][]routes = {{1,2,7},{3,6,7}};
        int source = 1,target = 6;
        System.out.println(new BusRoute().numBusesToDestination(routes,source,target));
    }
    /*public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                graph.computeIfAbsent(routes[i][j],k->new ArrayList<>()).add(i);
            }
        }
        Queue<Integer>queue = new ArrayDeque<>();
        Set<Integer>seen = new HashSet<>();
        for(int busRoutes : graph.get(source)) {
            queue.add(busRoutes);
            seen.add(busRoutes);
        }
        int noOfBuses = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Integer route = queue.poll();
                for(int stop : routes[route]) {
                    if(stop == target) return noOfBuses;
                    for(int nextRoute : graph.get(stop)) {
                        if(!seen.contains(nextRoute)) {
                            queue.add(nextRoute);
                            seen.add(nextRoute);
                        }
                    }
                }
            }
            noOfBuses++;
        }
        return -1;
    }*/
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                graph.computeIfAbsent(routes[i][j],k->new ArrayList<>()).add(i);
            }
        }
        Queue<int []>queue = new ArrayDeque<>();
        Set<Integer>seen = new HashSet<>();
        Set<Integer>visitedRoutes = new HashSet<>();
        queue.add(new int[]{source,0});
        seen.add(source);
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currNode = poll[0];
            int noOfBuses = poll[1];
            if(currNode == target) return noOfBuses;
            for(int i : graph.get(currNode)) {
                if(visitedRoutes.contains(i)) continue;
                for(int j : routes[i]) {
                    if(!seen.contains(j)) {
                        queue.add(new int[]{j,noOfBuses+1});
                        seen.add(j);
                    }
                }
                visitedRoutes.add(i);
            }
        }
        return -1;
    }
}
