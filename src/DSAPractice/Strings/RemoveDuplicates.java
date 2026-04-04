package DSAPractice.Strings;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "zvvo";
        System.out.println(removeDups(str));
    }
    static String removeDups(String S) {
        Boolean []dict = new Boolean[26];
        for(int i = 0; i < 26; i++) {
            dict[i] = false;
        }
        String result = "";
        for(int i = 0; i < S.length(); i++) {
            if(dict[S.charAt(i)-'a']) {
                continue;
            }else {
                dict[S.charAt(i)-'a'] = true;
                result+=S.charAt(i);
            }
        }
        return result;
    }
}
