package LeetCode_Crash_Course.Hashing;

import java.util.*;

public class FindPlayersWithZeroorOneLosses {
    public static void main(String[] args) {
//        int [][]matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        int [][]matches = {{1,5},{2,5},{2,8},{2,9},{3,8},{4,7},{4,9},{5,7},{6,8}};

        System.out.println(findWinners(matches));


    }
    public static List<List<Integer>> findWinners(int[][] matches) {
       /* HashSet<Integer>zero_loss = new HashSet<>();
        HashSet<Integer>one_loss = new HashSet<>();
        HashSet<Integer>more_loss = new HashSet<>();
        List<List<Integer>>result = Arrays.asList(new ArrayList<>(),new ArrayList<>());
        for(int [] match : matches) {
            int winner = match[0];
            int losser = match[1];
            if(!one_loss.contains(winner) && !more_loss.contains(winner)) {
                zero_loss.add(winner);
            }
            if(zero_loss.contains(losser)) {
                zero_loss.remove(losser);
                one_loss.add(losser);
            }else if(one_loss.contains(losser)) {
                one_loss.remove(losser);
                more_loss.add(losser);
            }else if(more_loss.contains(losser)) {
                continue;
            }else {
                one_loss.add(losser);
            }
        }
        result.get(0).addAll(zero_loss);
        result.get(1).addAll(one_loss);
        Collections.sort(result.get(0));
        Collections.sort(result.get(1));
        return  result;*/
        List<List<Integer>>result = Arrays.asList(new ArrayList<>(),new ArrayList<>());
        HashMap<Integer,Integer>lose_count = new HashMap<>();
        for(int [] match : matches) {
            int winner = match[0], loser = match[1];
            lose_count.put(winner,lose_count.getOrDefault(winner,0));
            lose_count.put(loser,lose_count.getOrDefault(loser,0)+1);
        }
        for(Integer key : lose_count.keySet()) {
            if(lose_count.get(key) == 0) {
                result.get(0).add(key);
            }else if(lose_count.get(key)== 1) {
                result.get(1).add(key);
            }
        }
        return result;
    }
}
