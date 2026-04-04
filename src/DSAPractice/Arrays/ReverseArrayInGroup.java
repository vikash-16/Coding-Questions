package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArrayInGroup {
    public static void main(String[] args) {
     ArrayList<Integer>arr = new ArrayList<>(Arrays.asList(5,6,8,9));
        reverseInGroups(arr,arr.size(),3);
        for(int i: arr) {
            System.out.println(i);
        }
    }
    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        int noOfGroups = 0;
        if(n%k == 0) {
            noOfGroups = n/k;
        }else {
            noOfGroups = n/k + 1;
        }
        int start = 0;
        int end = 0;
        int i = 0;
        while (i < noOfGroups) {
            start = i*k;
            end = Math.min((i+1)*k,n);
            reverseList(arr,start,end-1);
            i++;
        }
    }

    private static void reverseList(ArrayList<Integer> arr, int start, int end) {
        while(start < end) {
            int temp = arr.get(end);
            arr.set(end,arr.get(start));
            arr.set(start,temp);
            start++;
            end--;
        }
    }
}
