package LeetCode_Crash_Course.Hashing;

import java.util.HashSet;

public class CheckiftheSentenceIsPangram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }
    public static boolean checkIfPangram(String sentence) {
        HashSet<Character>dict = new HashSet<>();
        for(Character c : sentence.toCharArray()) {
            dict.add(c);
        }
        return dict.size() == 26;
    }
}
