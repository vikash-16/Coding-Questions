package DSAPractice.Backtracking;

import java.util.*;

public class LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b2";
        List<String> result = new LetterCasePermutation().letterCasePermutation(s);
        System.out.println(result.size());
        for(String e : result) {
            System.out.println(e);
        }
    }
    Set<String> result = new HashSet<>();
    public List<String> letterCasePermutation(String s) {
        long st = System.currentTimeMillis();
        letterCasePermutationHelper(s.toCharArray(),0);
        long ed = System.currentTimeMillis();
        System.out.println(ed-st);
        return new ArrayList<>(result);
    }

    private void letterCasePermutationHelper(char[] s, int i) {
        if(i == s.length) {
            result.add(String.valueOf(s));
            return;
        }
        if(Character.isLetter(s[i])) {
            s[i] = Character.toUpperCase(s[i]);
            letterCasePermutationHelper(s, i + 1);
            s[i] = Character.toLowerCase(s[i]);
            letterCasePermutationHelper(s, i + 1);
        }else {
            letterCasePermutationHelper(s,i+1);
        }
    }
}
