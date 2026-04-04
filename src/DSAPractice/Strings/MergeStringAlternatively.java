package DSAPractice.Strings;

public class MergeStringAlternatively {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        System.out.println(new MergeStringAlternatively().mergeAlternately(word1,word2));
    }
    public String mergeAlternately(String word1, String word2) {
        int index = 0;
        int i = 0, j = 0;
        StringBuilder str = new StringBuilder();
        while (i < word1.length() && j < word2.length()) {
            if(index % 2 == 0)
                str.append(word1.charAt(i++));
             else
                str.append(word2.charAt(j++));
             index++;
        }
        while(i < word1.length()) {
            str.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            str.append(word2.charAt(j++));
        }
        return str.toString();
    }

}
