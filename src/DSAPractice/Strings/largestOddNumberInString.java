package DSAPractice.Strings;

public class largestOddNumberInString {
    public static void main(String[] args) {
        String s = "35427";
        System.out.println(new largestOddNumberInString().largestOddNumber(s));
    }
    public String largestOddNumber(String num) {
        char[] charArray = num.toCharArray();
        int i = num.length()-1;
        while (i >= 0) {
            if(Integer.valueOf(num.charAt(i)) % 2 != 0)
                break;
            else
                i--;
        }
        return num.substring(0,i+1);
    }
}
