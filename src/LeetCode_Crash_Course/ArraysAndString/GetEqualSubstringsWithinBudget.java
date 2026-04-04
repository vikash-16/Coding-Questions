package LeetCode_Crash_Course.ArraysAndString;

public class GetEqualSubstringsWithinBudget {
    public static void main(String[] args) {
        String s = "abcd", t = "cdef";
        int maxCost = 3;
        System.out.println(equalSubstring(s,t,maxCost));
    }
    public static int equalSubstring(String s, String t, int maxCost) {
        int left = 0,currCost = 0;
        int maxLen = 0;
        for(int right = 0; right < s.length(); right++) {
            currCost+=Math.abs(s.charAt(right)-t.charAt(right));
            while (currCost > maxCost) {
                currCost-=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}
