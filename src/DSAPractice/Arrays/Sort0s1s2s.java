package DSAPractice.Arrays;

public class Sort0s1s2s {
    public static void main(String [] args) {
        int [] a = {1,2,0,1,2,2,0,1,0,1,0,2};
        sort012(a,a.length);
        for(int ele:a) {
            System.out.println(ele);
        }
    }

    private static void sort012(int[] a, int length) {
        int zero = 0;
        int one = 0;
        int two = length-1;
        while(one <= two) {
            if(a[one] == 0) {
                swapTwoNumbers(a,zero,one);
                zero++;
                one++;
            }else if(a[one] == 1){
                one++;
            }else if(a[one] == 2) {
                swapTwoNumbers(a,one,two);
                two--;
            }
        }
    }

    private static void swapTwoNumbers(int[] a, int num1, int num2) {
        int temp = a[num1];
        a[num1] = a[num2];
        a[num2] = temp;
    }
}
