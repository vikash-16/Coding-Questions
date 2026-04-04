package DSAPractice.Arrays;

public class RearrangeElementsBySign {
    public static void main(String[] args) {
        int []nums = {3,1,-2,-5,2,-4};
        int[] ints = rearrangeArray(nums);
        for(int x: ints) {
            System.out.println(x);
        }
    }
    public static int[] rearrangeArray(int[] nums) {
        int[] res = new int [nums.length];
        int positive = 0; int negative = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                res[positive] = nums[i];
                positive+=2;
            }else{
                res[negative] = nums[i];
                negative+=2;
            }
        }
        return res;
        /*List<Integer> pos = new ArrayList<>();
        List<Integer>neg = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }
        int i = 0; int j = 0;
        int index = 0;
        int [] result = new int[nums.length];
        while(i < pos.size() && j < neg.size()) {
            result[index++] = pos.get(i++);
            result[index++] =  neg.get(j++);
        }
        while(i < pos.size()) {
            result[index++] = pos.get(i++);
        }
        while(j < neg.size()) {
            result[index++] = neg.get(j++);
        }
        return result;*/
    }
}
