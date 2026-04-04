package LeetCode_Crash_Course.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int [] nums1 = {1,3,5,2,4},nums2 = {6,5,4,3,2,1,7};
        System.out.println(Arrays.toString(new NextGreaterElement1().nextGreaterElement(nums1,nums2)));
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> dict =new HashMap<>();
        Stack<Integer>st = new Stack<>();
        int [] res = new int[nums1.length];
        for(int num: nums2) {
            while (!st.empty() && num > st.peek()) {
                dict.put(st.pop(), num);
            }
            st.push(num);
        }
        while (!st.empty()) {
            dict.put(st.pop(),-1);
        }
        for(int i = 0; i < nums1.length; i++) {
            res[i] = dict.get(nums1[i]);
        }
        return res;
    }

}
