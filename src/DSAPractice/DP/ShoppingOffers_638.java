package DSAPractice.DP;

import java.util.Arrays;
import java.util.List;

public class ShoppingOffers_638 {
    public static void main(String[] args) {
        List<Integer> price = List.of(2,3,4);
        List<List<Integer>> special = List.of(List.of(1,1,0,4),List.of(2,2,1,9));
        List<Integer> needs = List.of(1,2,1);
        System.out.println(new ShoppingOffers_638().shoppingOffers(price,special,needs));

    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int[] p = price.stream().mapToInt(Integer::intValue).toArray();
        int[][] s = special.stream()
                .map(list -> list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
        int[] n = needs.stream().mapToInt(Integer::intValue).toArray();
        return unboundedKnapsack(p,s,n,0);
    }

    private int unboundedKnapsack(int[] price , int[][] special, int[] needs,int index) {
        if(index == special.length) {
            int res = 0;
            for(int i = 0; i < price.length; i++) {
                res+=price[i]*needs[i];
            }
            return res;
        }
        int rejectOffers = unboundedKnapsack(price, special, needs, index + 1);
        int[] tempNeeds = Arrays.copyOf(needs, needs.length);
        for(int i = 0; i < needs.length; i++) {
            tempNeeds[i] = tempNeeds[i]-special[index][i];
            if(tempNeeds[i] < 0) {
                return rejectOffers;
            }
        }
        int acceptOffers = special[index][tempNeeds.length] + unboundedKnapsack(price, special, tempNeeds, index);
        return Math.min(rejectOffers,acceptOffers);
    }

    private int unboundedKnapsack(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index) {
        if(index == special.size()) {
            int res = 0;
            for(int i = 0; i < price.size(); i++) {
                res += price.get(i)*needs.get(i);
            }
            return res;
        }
        int rejectOffers = unboundedKnapsack(price, special, needs, index + 1);
        for(int i = 0; i < needs.size(); i++) {
            Integer val = needs.get(i) - special.get(index).get(i);
            needs.set(i,val);
            if(needs.get(i) < 0) {
                return rejectOffers;
            }
        }
        int acceptOffers = special.get(index).get(needs.size()) + unboundedKnapsack(price, special, needs, index);
        return Math.min(rejectOffers,acceptOffers);
    }
    private int unboundedKnapsack2(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index) {
//      int[] arr =price.stream().mapToInt(Integer::intValue).toArray();
//      Integer[] arr1=price.toArray(new Integer[arr.length]);

        if(index == special.size()) {
            int res = 0;
            for(int i = 0; i < price.size(); i++) {
                res += price.get(i)*needs.get(i);
            }
            return res;
        }
        int rejectOffers = unboundedKnapsack2(price, special, needs, index + 1);
        for(int i = 0; i < needs.size(); i++) {
            Integer val = needs.get(i) - special.get(index).get(i);
            needs.set(i,val);
            if(needs.get(i) < 0) {
                return rejectOffers;
            }
        }
        int acceptOffers = special.get(index).get(needs.size()) + unboundedKnapsack2(price, special, needs, index);
        return Math.min(rejectOffers,acceptOffers);
    }
}
