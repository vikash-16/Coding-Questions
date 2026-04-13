package LeetCode75.Arrays_String;

import java.util.ArrayList;
import java.util.List;

public class CanVisitAllRooms {
    public static void main(String[] args) {

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Boolean []visited = new Boolean[rooms.size()];
        dfshelper(rooms,visited,0);
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == false) {
                return false;
            }
        }
        return true;
    }

    private void dfshelper(List<List<Integer>> rooms, Boolean[] visited, int node) {
        if(visited[node] == true) {
            return;
        }
        visited[node]= true;
        for(int i = 0; i < rooms.get(node).size(); i++) {
            dfshelper(rooms,visited,rooms.get(node).get(i));
        }
    }
}
