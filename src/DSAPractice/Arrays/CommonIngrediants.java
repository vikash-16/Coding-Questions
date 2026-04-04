package DSAPractice.Arrays;

import java.util.*;

public class CommonIngrediants {
    public static void main(String[] args) {
        int[] recipe1 = {1,1,1 ,2, 3,6};
        int[] recipe2 = {1,1,5, 6, 7};
        System.out.println(findCommonIngredients(recipe1,recipe2));
    }
    public static List<Integer> findCommonIngredients(int[] recipe1, int[] recipe2) {
        HashMap<Integer,Integer>recipe1Counts = new HashMap<>();
        List<Integer>result = new ArrayList<>();
        for(int ingredient : recipe1) {
            recipe1Counts.put(ingredient,recipe1Counts.getOrDefault(ingredient,0)+1);
        }
        for(int ingredient : recipe2) {
            if(recipe1Counts.containsKey(ingredient) && recipe1Counts.get(ingredient) > 0) {
                result.add(ingredient);
                recipe1Counts.put(ingredient,recipe1Counts.get(ingredient)-1);
            }
        }
        if(result.size() < 1) {
            result.add(-1);
            return result;
        }
        return result;
    }
}
