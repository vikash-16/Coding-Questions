package DSAPractice.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,2,3,4,5};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int maxWater = Integer.MIN_VALUE, h = 0, low = 0, high = height.length-1;
        while(low < high) {
            h = Math.min(height[low],height[high]);
            maxWater = Math.max(maxWater, h*(high-low));
            while (height[low] <= h && low < high)   low++;
            while (height[high] <= h && low < high)  high--;
        }
        return maxWater;
    }
}
