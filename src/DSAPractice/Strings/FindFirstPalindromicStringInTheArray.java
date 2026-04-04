package DSAPractice.Strings;

public class FindFirstPalindromicStringInTheArray {
    public static void main(String[] args) {
        String [] words = {"abc","car","ada","racecar","cool"};
        System.out.println(new FindFirstPalindromicStringInTheArray().firstPalindrome(words));
    }
    public String firstPalindrome(String[] words) {
        for(String word : words) {
            String string = new StringBuilder(word).reverse().toString();
            if(word.equalsIgnoreCase(string)) {
                return word;
            }
        }
        return "";
    }

}
