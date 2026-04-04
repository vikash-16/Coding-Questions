package LeetCode_Crash_Course.ArraysAndString;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));
    }
    public static String reverseOnlyLetters(String s) {
        char[] str = s.toCharArray();
        int left = 0,right = s.length()-1;
        while (left < right) {
            if(isAlphabet(str[left]) && isAlphabet(str[right])) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }else if(isAlphabet(str[left])) {
                left++;
            }else {
                right--;
            }
        }
        return new String(str);
    }

    private static boolean isAlphabet(char c) {
        if((c >= 65 && c <=90) || (c >= 97 && c <= 122)) {
            return true;
        }
        return false;
    }
}
