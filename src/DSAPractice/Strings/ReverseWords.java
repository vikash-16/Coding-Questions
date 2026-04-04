package DSAPractice.Strings;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "i.like.this.program.very.much";
        System.out.println(reverseWords(s));
    }
    static String reverseWords(String S)
    {
        String[] split = S.split("\\.");
        String result = "";
        for(int i = split.length-1; i >= 0; i--) {
            if(i == 0) {
                result+=split[i];
            }else {
                result+=split[i]+".";
            }
        }
        return result;
    }
}
