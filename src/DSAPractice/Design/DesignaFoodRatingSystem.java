package DSAPractice.Design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignaFoodRatingSystem {
    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int []ratings = {9, 12, 8, 15, 14, 7};
        new DesignaFoodRatingSystem().FoodRatings(foods,cuisines,ratings);
    }
    Map<String,Integer>foodRatingMap = new HashMap<>();
    Map<String,String>foodCuisinessMap = new HashMap<>();
    Map<String, PriorityQueue<Food>>cuisinedAndFoodMap = new HashMap<>();
    public void FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++) {
            foodRatingMap.put(foods[i],ratings[i]);
            foodCuisinessMap.put(foods[i],cuisines[i]);
            cuisinedAndFoodMap.computeIfAbsent(cuisines[i],k->new PriorityQueue<Food>()).add(new Food(ratings[i],foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food,newRating);
        cuisinedAndFoodMap.get(foodCuisinessMap.get(food)).add(new Food(newRating,food));
    }

    public String highestRated(String cuisine) {
        Food highestRated = cuisinedAndFoodMap.get(cuisine).peek();

        while (foodRatingMap.get(highestRated.foodName) != highestRated.foodRating) {
            cuisinedAndFoodMap.get(cuisine).poll();
            highestRated = cuisinedAndFoodMap.get(cuisine).peek();
        }

        // Return the name of the highest-rated 'food' of 'cuisine'.
        return highestRated.foodName;
    }
}
