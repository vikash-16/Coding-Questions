package DSAPractice.Arrays;

import java.util.*;

public class FindPlayersWithZeroorOneLosses {
    public static void main(String[] args) {
        int [][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> winners = new FindPlayersWithZeroorOneLosses().findWinners(matches);
        System.out.println(winners);
    }
    public List<List<Integer>> findWinners(int[][] matches) {
        TreeSet<Integer> teams = new TreeSet<>();
        Map<Integer,Integer> lossMathches = new HashMap<>();
        for(int [] match : matches) {
            teams.add(match[0]);
            teams.add(match[1]);
            lossMathches.put(match[1],lossMathches.getOrDefault(match[1],0)+1);
        }
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>lossZeroMatch = new ArrayList<>();
        List<Integer>lossOneMatch = new ArrayList<>();
        for(Integer player : teams) {
            if(!lossMathches.containsKey(player)) {
                lossZeroMatch.add(player);
            }else if(lossMathches.get(player) == 1) {
                lossOneMatch.add(player);
            }
        }
        result.add(lossZeroMatch);
        result.add(lossOneMatch);
        return result;
    }
}
