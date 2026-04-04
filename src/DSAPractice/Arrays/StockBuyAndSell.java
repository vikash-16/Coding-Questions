package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int arr[] = {100,180,260,310,40,535,695};
        ArrayList<ArrayList<Integer>> arrayLists = stockBuySell(arr, arr.length);
    }
    static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i = 0;
        int buyDay = 0,sellDay = 0;
        while(i < n-1) {
            while(i < n-1 && A[i] > A[i+1]) {
                i++;
            }
            buyDay = i++;
            if(i == n-1) {
                break;
            }
            while(i < n && A[i] > A[i-1]) {
                i++;
            }
            sellDay = i-1;
            result.add(new ArrayList<>(Arrays.asList(buyDay,sellDay)));
        }
        return result;
    }
}
