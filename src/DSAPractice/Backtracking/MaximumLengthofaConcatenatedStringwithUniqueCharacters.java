package DSAPractice.Backtracking;

import java.util.*;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    public static void main(String[] args) {
        List<String>arr = new ArrayList<>(List.of("un","iq","ue"));
        System.out.println(new MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(arr));
    }
    private int result = 0;

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        backTrackHelper(arr, "", 0);
        return result;
    }

    private void backTrackHelper(List<String> arr, String path, int idx) {
        boolean isUniqueChar = isUniqueChars(path);
        if (isUniqueChar) {
            result = Math.max(path.length(), result);
        }
        if (idx == arr.size() || !isUniqueChar) {
            return;
        }
        for (int i = idx; i < arr.size(); i++) {
            backTrackHelper(arr, path + arr.get(i), i + 1);
        }
    }

    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

}
