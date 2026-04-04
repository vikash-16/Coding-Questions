package DSAPractice.Strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String str = "CMXVI";
        System.out.println(romanToDecimal(str));
    }
    public static int romanToDecimal(String str) {
        Map<Character,Integer>dict = new HashMap<>();
        int number = 0;
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X',10);
        dict.put('L',50);
        dict.put('C',100);
        dict.put('D',500);
        dict.put('M',1000);
        if(str.length() == 1) {
            return dict.get(str.charAt(0));
        }else {
            for (int i = 0; i < str.length() - 1; i++) {
                if (dict.get(str.charAt(i)) >= dict.get(str.charAt(i + 1))) {
                    number += dict.get(str.charAt(i));
                } else {
                    number += dict.get(str.charAt(i + 1)) - dict.get(str.charAt(i));
                    i++;
                }
            }
            if(dict.get(str.charAt(str.length()-1)) <= dict.get(str.charAt(str.length()-2))) {
                number+=dict.get(str.charAt(str.length()-1));
            }
        }
        return number;
    }
}
