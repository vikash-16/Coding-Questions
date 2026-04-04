package DSAPractice.Arrays;

import java.lang.reflect.Array;
import java.util.*;

public class NumberOfFlowersInFullBloom {
    public static void main(String[] args) {
       int [][] flowers = {{1,6},{3,7},{9,12},{4,13}};
       int [] poeple = {2,3,7,11};
        System.out.println(Arrays.toString(new NumberOfFlowersInFullBloom().fullBloomFlowers(flowers,poeple)));
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople);
        Arrays.sort(flowers,(a,b)-> a[0]-b[0]);
        Map<Integer,Integer> dict = new HashMap<>();
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        int i = 0;
        for(int person : sortedPeople) {
            while(i < flowers.length && flowers[i][0] <= person) {
                pq.add(flowers[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek() < person) {
                pq.remove();
            }
            dict.put(person,pq.size());
        }
        int [] result = new int[people.length];
        for(int k = 0; k < people.length; k++) {
            result[k] = dict.get(people[k]);
        }
        return result;
    }
}
