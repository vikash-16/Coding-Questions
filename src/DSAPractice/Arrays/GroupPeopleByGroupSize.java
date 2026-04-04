package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeopleByGroupSize {
    public static void main(String[] args) {
        int [] arr = {2,1,3,3,3,2};
        List<List<Integer>> lists = groupThePeople(arr);
        System.out.println(lists);


    }
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>>result = new ArrayList<>();
        Map<Integer, List<Integer>> group = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = group.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
            list.add(i);
            if(list.size() == groupSizes[i]) {
                result.add(list);
                group.put(groupSizes[i],new ArrayList<>());
            }
        }
        return result;
    }
}
