package DSAPractice.Arrays;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        long [] arr1 = {1,3,5,7};
        long [] arr2 = {0,2,6,8,9};
        merge(arr1,arr2,4,5);
    }
    public static void merge(long arr1[], long arr2[], int n, int m)
    {
        int i=n-1;

        int j=0;

        while(i>=0 && j<m){

            if(arr1[i]>arr2[j]){

                long temp=arr1[i];

                arr1[i]=arr2[j];

                arr2[j]=temp;

                i++;

                j--;

            }

            if(i==0 && arr1[i]<arr2[j]){

                break;

            }

            else{

                i--;

                j++;

            }

        }

        Arrays.sort(arr1);

        Arrays.sort(arr2);
    }
}
