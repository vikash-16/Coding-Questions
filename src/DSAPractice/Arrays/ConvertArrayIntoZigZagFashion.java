package DSAPractice.Arrays;

public class ConvertArrayIntoZigZagFashion {
    public static void main(String[] args) {
        int arr[] = {4, 3, 7, 8, 6, 2, 1};
        zigZag(arr,arr.length);
    }
   static void zigZag(int arr[], int n) {
        for(int i = 0; i < n-1; i++) {
            if(i%2 == 0 && arr[i] > arr[i+1]) {
                swapElements(arr,i,i+1);
            }else if(i%2 != 0 && arr[i] < arr[i+1]) {
                swapElements(arr,i,i+1);
            }
        }
    }

    private static void swapElements(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
