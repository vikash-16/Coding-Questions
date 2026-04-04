package LeetCode_Crash_Course.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class JewelsandStones {
    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels,stones));
    }
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        HashSet<Character>jewelStoneCount = new HashSet<>();
        for(Character c : jewels.toCharArray()) {
            jewelStoneCount.add(c);
        }
        for(Character c : stones.toCharArray()) {
            if(jewelStoneCount.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
