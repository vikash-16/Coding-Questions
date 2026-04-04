package Interview;

import javax.swing.text.StyledEditorKit;
import java.lang.reflect.Array;
import java.util.Arrays;

public class AnaGram {
    public static void main(String[] args) {

        String s1 = "listen", s2 = "silent";
        boolean anagram = new AnaGram().isAnagram(s1, s2);
        System.out.println(anagram);

    }
    public boolean isAnagram(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        Arrays.sort(str1);
        char[] str2 = s2.toCharArray();
        Arrays.sort(str2);
        for(int i = 0; i < s1.length();i++) {
            if(str1[i] != str2[i]) {
                return false;
            }
        }
        return true;
    }
}
