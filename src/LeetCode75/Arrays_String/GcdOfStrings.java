package LeetCode75.Arrays_String;

public class GcdOfStrings {
    public static void main(String[] args) {
        GcdOfStrings gcdOfStrings = new GcdOfStrings();
        String string = gcdOfStrings.gcdOfStrings("ABCABC", "ABC");
        System.out.println(string);
    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) {
            return "";
        }
        int gcdVal = getGcdVal(str1.length(), str2.length());
        return str1.substring(0,gcdVal);
    }

    private int getGcdVal(int a, int b) {
        if(b == 0) return a;
        return getGcdVal(b,a%b);

    }
}
