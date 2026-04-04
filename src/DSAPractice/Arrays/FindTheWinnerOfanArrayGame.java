package DSAPractice.Arrays;

import java.util.ArrayDeque;

public class FindTheWinnerOfanArrayGame {
    public static void main(String[] args) {
        int [] arr = {1,25,35,42,68,70};
        int k = 1;
        System.out.println(new FindTheWinnerOfanArrayGame().getWinner(arr,k));
    }
    public int getWinner(int[] arr, int k) {
        int maxEle = Integer.MIN_VALUE;
        for(int i = 0; i< arr.length; i++) {
            maxEle = Math.max(maxEle,arr[i]);
        }
        if(k >= arr.length) return maxEle;
        if(arr.length == 2) {
            return Math.max(arr[0],arr[1]);
        }
        int i = 0, j = 1;
        int currentWinner = 0;
        int count = 0;
        while (j < arr.length) {
            if(arr[i] > arr[j]) {
                if(arr[i] == currentWinner) {
                    count++;
                    j++;
                }else {
                    currentWinner = arr[i];
                    count = 1;
                    j++;
                }
            }else {
                if(currentWinner == arr[j]) {
                    count++;
                    j++;
                }else {
                    currentWinner = arr[j];
                    count = 1;
                    i = j;
                    j++;
                }
            }
            if(count == k) {
                return currentWinner;
            }
        }
        return currentWinner;
    }
}
