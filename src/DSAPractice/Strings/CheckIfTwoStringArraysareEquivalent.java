package DSAPractice.Strings;

public class CheckIfTwoStringArraysareEquivalent {
    public static void main(String[] args) {
        String[]word1 = {"ab", "c"}, word2 = {"a", "bcd"};
        System.out.println(new CheckIfTwoStringArraysareEquivalent().arrayStringsAreEqual(word1,word2));
    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        /*StringBuilder str = new StringBuilder();
        for(String s : word1) {
            str.append(s);
        }
        int length = str.length();
        for(String s: word2) {
            str.append(s);
        }
        if(str.length()!= 2*length) return false;
        int i = 0,j = length;
        String str1 = str.toString();
        while (i < length && j < str.length()) {
            if(str1.charAt(i++) != str1.charAt(j++)) return false;
        }
        return true;*/
        return String.join("",word1).equalsIgnoreCase(String.join("",word2));
    }
}
