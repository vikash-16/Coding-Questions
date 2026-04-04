package DSAPractice.Arrays;

import java.util.Arrays;

public class LargestNumberFormedFromAnArray {
    public static void main(String[] args) {
        String arr[] = {"3", "30", "34", "5", "9"};
        System.out.println(printLargest(arr));
    }
    static String printLargest(String[] arr) {
        Arrays.sort(arr,(a,b)-> {
            return (b + a).compareTo(a + b);
        });
        String result = "";
        for(String s: arr) {
            result+=s;
        }
        return result;
    }
}
