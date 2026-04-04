package LeetCode_Crash_Course.Stack;

import java.util.Stack;

public class OnlineStockSpan {
    public static void main(String[] args) {
        int [] nums= {100, 80, 60, 70, 60, 75, 85};
        for(int i: nums) {
        }
    }
    class StockSpanner {
        Stack<int []>st = new Stack<>();
        public StockSpanner() {

        }

        public int next(int price) {
            int ans = 1;
            while(!st.empty() && st.peek()[0] <= price) {
                ans+=st.pop()[1];
            }
            st.push(new int[]{price,ans});
            return ans;
        }
    }

}
