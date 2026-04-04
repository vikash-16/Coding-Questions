package DSAPractice.Strings;

public class Anagram {
    public static void main(String[] args) {
        String a = "geeksforgeeks";
        String b = "forgeeksgeek";
        System.out.println(isAnagram(a,b));
    }
    public static boolean isAnagram(String a,String b)
    {
        if(a.length() != b.length()) {
            return false;
        }
        int [] dict= new int[26];
        for(int i = 0; i < a.length(); i++) {
            dict[a.charAt(i)-'a']++;
            dict[b.charAt(i)-'a']--;
        }
        for(int i: dict) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
}
