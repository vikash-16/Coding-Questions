package LeetCode_Crash_Course.ArraysAndString;

public class ReversePrefixOfWord {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word,ch));
    }
    public static String reversePrefix(String word, char ch) {
        int endIndex = -1;
        int startIndex = 0;
        char[] str = word.toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(str[i] == ch) {
                endIndex = i;
                break;
            }
        }
        if(endIndex != -1) {
            while(startIndex < endIndex) {
                char temp = str[startIndex];
                str[startIndex] = str[endIndex];
                str[endIndex] = temp;
                startIndex++;
                endIndex--;
            }
        }
        return new String(str);
    }
}
