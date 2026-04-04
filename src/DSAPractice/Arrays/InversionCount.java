package DSAPractice.Arrays;

public class InversionCount {
    public static void main(String[] args) {
        long arr[] = {2, 4, 1, 3, 5};
        int n = 5;
        inversionCount(arr,n);
    }

    private static void inversionCount(long[] arr, long n) {
        long res = mergerSort(arr, 0, n - 1);
        System.out.println(res);
    }

    private static long mergerSort(long[] arr, long start, long end) {
        long res = 0;
        if(start < end) {
            long mid = start + (end-start)/2;
            res+=mergerSort(arr,start,mid);
            res+=mergerSort(arr,mid+1,end);
            res+=inversionCountAndMerge(arr,start,mid,end);
        }
        return res;
    }

    private static long inversionCountAndMerge(long[] arr, long start, long mid, long end) {
        long len1 = mid-start+1;
        long len2 = end-mid;
        long left[] = new long[(int) len1];
        long right[] = new long[(int) len2];
        for(long i = 0; i < len1; i++) left[(int) i] = arr[(int) (start+i)];
        for(long i = 0; i < len2; i++) right[(int) i] = arr[(int) (mid+i+1)];
        long i = 0,j = 0, index = start;
        long res = 0;
        while(i < len1 && j < len2) {
            if(left[(int) i] < right[(int) j]) {
                arr[(int) index++] = left[(int) i++];
            }else {
                arr[(int) index++] = right[(int) j++];
                res+= len1-i;
            }
        }
        while(i < len1) {
            arr[(int) index++] = left[(int) i++];
        }
        while(j < len2) {
            arr[(int) index++] = right[(int) j++];
        }
        return res;
    }
}
