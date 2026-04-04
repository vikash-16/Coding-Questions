package DSAPractice.Strings;

public class SecondLargestDigitInString {
    public static void main(String[] args) {
        String s = "abc1111";
        System.out.println(new SecondLargestDigitInString().secondHighest(s));
    }
    public int secondHighest(String s) {
        int first = -1,second = -1;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                if(first < c-'0' && second < first) {
                    second = first;
                    first = c-'0';
                }else if(first < c-'0') {
                    first = c-'0';
                }else if(first != c-'0' && second < c-'0') {
                    second = c-'0';
                }
            }
        }
        return second;
    }
}
