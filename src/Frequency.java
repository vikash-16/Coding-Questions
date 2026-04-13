public class Frequency {
    public static void main(String[] args) {
        String s = "sameer";
        int [] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c-'a']++;
        }
        for(int i = 0; i < 26; i++) {
            char c = (char) (i+'a');
            System.out.println(c+" "+freq[i]);
        }
    }

}
