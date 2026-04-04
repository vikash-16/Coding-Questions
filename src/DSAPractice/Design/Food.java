package DSAPractice.Design;

public class Food implements Comparable<Food> {
    public int foodRating;
    public String foodName;
    public Food(int rating,String food) {
        this.foodRating = rating;
        this.foodName = food;
    }
    @Override
    public int compareTo(Food food) {
        if(foodRating == food.foodRating) {
            return foodName.compareTo(food.foodName);
        }
        return -1 * Integer.compare(foodRating,food.foodRating);
    }
}
