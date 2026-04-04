package TopInterView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

public class RomanToInteger {
    public static void main(String[] args) {
        /*List<String> s = Arrays.asList("LVIII","MCMXCIV");
        for(String str: s) {
            System.out.println(romanToInteger(str));
        }*/
        int []nums = {2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(ints.toString());
    }

    private static Integer romanToInteger(String str) {
        Integer number = 0;
        Map<Character,Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X',10);
        dict.put('L',50);
        dict.put('C',100);
        dict.put('D',500);
        dict.put('M',1000);
        if(str.length() == 1) {
            return dict.get(str.charAt(0));
        }
        for(int i = 0; i < str.length()-1; i++) {
            if(dict.get(str.charAt(i)) >= dict.get(str.charAt(i+1))) {
                number+=dict.get(str.charAt(i));
            }else {
                number+=dict.get(str.charAt(i+1))-dict.get(str.charAt(i));
                i++;
            }
        }
        if(dict.get(str.charAt(str.length()-1)) <= dict.get(str.charAt(str.length()-2))) {
            number+=dict.get(str.charAt(str.length()-1));
        }
        return number;
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>dict = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(dict.containsKey(target-nums[i])) {
                return new int[]{dict.get(target-nums[i]),i};
            }
            dict.put(nums[i],i);
        }
        return null;
    }
}
