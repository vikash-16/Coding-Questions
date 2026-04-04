package DSAPractice.Arrays;

public class NumberofSubArraysWithOddSum {
    public static void main(String[] args) {
        System.out.println(new NumberofSubArraysWithOddSum().numOfSubarrays(new int[]{1,3,5}));
    }
    public int numOfSubarrays(int[] arr) {
        /*int [] presum = new int[arr.length+1];
        presum[1] = arr[0];
        for(int i = 2; i <= arr.length; i++) {
            presum[i] = arr[i-1] + presum[i-1];
        }
        int count = 0;
        for(int length = 1; length <= arr.length; length++) {
            for(int start = length; start <= arr.length;start++) {
                int sum = presum[start] - presum[start - length];
                System.out.println(sum);
                if((sum)%2 != 0) {
                    count++;
                }
            }
        }
        return count;*/
        int even = 0,odd = 0,count = 0;
        for(int a : arr) {
            if(a%2 == 0) {
                even++;
            }else{
                int temp = odd;
                odd = even;
                even = temp;
                odd++;
            }
            count = (count+odd)%1000000007;
        }
        return count;
    }
}
