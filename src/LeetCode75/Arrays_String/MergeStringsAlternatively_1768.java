package LeetCode75.Arrays_String;

public class MergeStringsAlternatively_1768 {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc","pqr"));
    }

    private static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int index = 0,i = 0,j = 0;
        while(i < word1.length() && j < word2.length()) {
            if(index % 2 == 0) {
                result.append(word1.charAt(i++));
            }else {
                result.append(word2.charAt(j++));
            }
            index++;
        }
        while (i < word1.length()) {
            result.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            result.append(word2.charAt(j++));
        }
        return result.toString();
    }

}

