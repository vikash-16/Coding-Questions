package DSAPractice.Strings;

public class DetermineifStringHalvesAreAlike {
    public static void main(String[] args) {
        String s = "textbook";
        System.out.println(new DetermineifStringHalvesAreAlike().halvesAreAlike(s));
    }
    public boolean halvesAreAlike(String s) {
        int n = s.length()/2;
        char[] array = s.toCharArray();
        int c1 = 0,c2 = 0;
        for(int i = 0; i < n; i++) {
            if(isVowel(array[i])) {
                c1++;
            }
            if(isVowel(array[n+i])) {
                c2++;
            }
        }
        return c1 == c2;
    }

    private boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ) return true;
        return false;
    }
}
