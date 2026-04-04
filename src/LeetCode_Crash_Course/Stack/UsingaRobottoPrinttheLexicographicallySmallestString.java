package LeetCode_Crash_Course.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class UsingaRobottoPrinttheLexicographicallySmallestString {
    public static void main(String[] args) {
        String s = "dbba";
        System.out.println(new UsingaRobottoPrinttheLexicographicallySmallestString().robotWithString(s));
    }
    public String robotWithString(String s) {
        StringBuilder str = new StringBuilder();
        int [] dict = new int[26];
        Arrays.fill(dict,-1);
        for(int i = 0; i < s.length(); i++) {
            dict[s.charAt(i)-'a'] = i;
        }
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
            while(!st.isEmpty()) {
                boolean exist = false;
                for(int ch = 0; ch < st.peek()-'a'; ch++) {
                    if(i < dict[ch]) {
                        exist = true;
                        break;
                    }
                }
                if(exist) break;
                str.append(st.pop());
            }
        }
        return str.toString();
    }
}
