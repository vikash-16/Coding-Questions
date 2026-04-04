package LeetCode75.Arrays_String;

import java.util.Arrays;
import java.util.List;

public class DecodeString {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("3[a]2[bc]","3[a2[c]]","2[abc]3[cd]ef");
        DecodeString decodeString = new DecodeString();
        for(int i = 0; i < input.size(); i++) {
            String string = decodeString.decodeString(input.get(i));
            System.out.println(string);
        }
    }
    int i = 0;
    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        int num = 0;
        while (i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                num = num*10+s.charAt(i)-'0';
                i++;
            }else if(s.charAt(i) == '['){
                i++;
                String intermediate = decodeString(s);
                for(int j = 0; j< num; j++) {
                    str.append(intermediate);
                }
                num = 0;
            }else if(s.charAt(i) == ']') {
                i++;
                return str.toString();
            }else {
                str.append(s.charAt(i));
                i++;
            }
        }
        return str.toString();
    }
}
