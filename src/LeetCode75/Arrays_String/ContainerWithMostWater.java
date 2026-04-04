package LeetCode75.Arrays_String;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int i = new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
    public int maxArea(int[] height) {
        int maxWater = Integer.MIN_VALUE, h = 0,low = 0,high = height.length-1;
        while(low < high) {
            h = Math.min(height[low],height[high]);
            maxWater = Math.max(maxWater,h*(high-low));
            while (low < high && height[low]<=h)low++;
            while (low < high && height[high] <= h) high--;
        }
        return maxWater;
    }
}
