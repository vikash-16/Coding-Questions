package LeetCode_Crash_Course.Stack;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int n = 4;
        long[] longs = new long[]{1,3,2,4};
        long[] arr = nextLargerElement(longs, n);
        for(long i: arr) {
            System.out.println(i);
        }
    }
    public static long[] nextLargerElement(long[] arr, int n)
    {
        Stack<Long> st = new Stack<Long>();
        long[] res = new long[n];
        st.push(arr[n-1]);
        res[n-1] = -1;
        for(int i = n-2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            if(st.isEmpty()) {
                res[i] = -1;
            }else {
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return res;
    }
}
