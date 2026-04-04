package DSAPractice.Strings;

import java.util.*;

public class PermutaionOfString {
    public static void main(String[] args) {
        String s = "ABC";
        List<String> permutation = find_permutation(s);
        for(String str: permutation) System.out.println(str);
    }
    public static List<String> find_permutation(String S) {
        List<String> result = new ArrayList<>();
        Set<String>set = new HashSet<>();
        getpermutation(S,0,S.length()-1,set);
        for(String str: set)
        {
            result.add(str);
        }
        Collections.sort(result);
        return result;
    }

    private static void getpermutation(String s, int left, int right, Set<String> result) {
        if (left == right) {
            result.add(s);
        } else {
            for (int index = left; index <= right; index++) {
                String swap = swap(s, left, index);
                getpermutation(swap, left + 1, right, result);
                 swap = swap(s, left, right);
            }
        }
    }

    private static String swap(String s, int e1, int e2) {
        char[] chars = s.toCharArray();
        char c = chars[e1];
        chars[e1] = chars[e2];
        chars[e2] = c;
        return String.valueOf(chars);
    }
}
