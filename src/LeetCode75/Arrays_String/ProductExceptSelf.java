package LeetCode75.Arrays_String;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] ints = new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(ints);
    }
    public int[] productExceptSelf(int[] nums) {
        int [] leftProduct = new int[nums.length];
        int []result = new int[nums.length];
        leftProduct[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i-1]*leftProduct[i-1];
        }
        int rightProduct = nums[nums.length-1];
        result[nums.length-1] = leftProduct[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--) {
            result[i] = leftProduct[i]*rightProduct;
            rightProduct*= nums[i];
        }
        return result;
    }
}
