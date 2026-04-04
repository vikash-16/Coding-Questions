package DSAPractice.Arrays;

import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {
        int [] heights = {2,1,5,6,2,3};
        System.out.println(new LargestRectangleArea().largestRectangleArea(heights));
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer>s = new Stack<>();
        int area = 0,maxArea = 0,stackTop = 0;
        int i = 0;
        while(i < n) {
            if(s.empty() || heights[s.peek()] <= heights[i]) {
                s.push(i++);
            }else {
                stackTop = heights[s.pop()];
                area = stackTop*i;
                if(!s.empty()) {
                    area = stackTop*(i-s.peek()-1);
                }
                maxArea = Math.max(area,maxArea);
            }
        }
        while (!s.empty()) {
            stackTop = heights[s.pop()];
            area = stackTop * i;
            if(!s.empty()) {
                area = stackTop*(i-s.peek()-1);
            }
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
