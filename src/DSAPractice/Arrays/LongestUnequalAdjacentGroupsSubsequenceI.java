package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"e","a","b"};
        int [] groups = {0,0,1};
        System.out.println(new LongestUnequalAdjacentGroupsSubsequenceI().getWordsInLongestSubsequence(n,words,groups));
    }
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String>result = new ArrayList<>();
        int lastGroup = groups[0];
        result.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            if(lastGroup != groups[i]) {
                lastGroup = groups[i];
                result.add(words[i]);
            }
        }
        return result;
    }
}
