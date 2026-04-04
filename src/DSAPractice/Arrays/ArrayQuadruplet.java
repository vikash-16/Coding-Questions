package DSAPractice.Arrays;

import java.util.Arrays;

public class ArrayQuadruplet {
    public static void main(String[] args) {
        int [] arr = {2, 7, 4, 0, 9, 5, 1, 3};
        int s = 20;
        System.out.println(Arrays.toString(findArrayQuadruplet(arr,s)));
    }
    static int[] findArrayQuadruplet(int[] arr, int s) {
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i < n-3; i++) {
            for(int j = i+1; j < n-2; j++) {
                int p = j+1;
                int q = n-1;
                while(p < q) {
                    int sum = arr[i]+arr[j]+arr[p]+arr[q];
                    if(sum == s) {
                        return new int []{arr[i],arr[j],arr[p],arr[q]};
                    }else if (sum < s) {
                        p++;
                    }else {
                        q--;
                    }
                }
            }
        }
        return new int[]{};
    }
}
