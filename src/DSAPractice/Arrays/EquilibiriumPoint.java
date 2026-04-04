package DSAPractice.Arrays;

public class EquilibiriumPoint {
    public static void main(String[] args) {
        long [] arr = {1};
        System.out.println(equilibriumPoint(arr,arr.length));
    }

    private static int equilibriumPoint(long[] arr, int n) {
        long totalSum = 0;
        long currSum = 0;
        for(long ele: arr) {
            totalSum+=ele;
        }
        for(int i = 0; i < n; i++) {
            totalSum-=arr[i];
            if(totalSum == currSum) {
                return i+1;
            }else {
                currSum+=arr[i];
            }
        }
        return -1;
    }
}
