package DSAPractice.Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"aa","aab"};
        String pre = longestCommonPrefix(arr, 2);
        System.out.println(pre);
    }
    static String longestCommonPrefix(String arr[], int n){
        if(n == 1) {
            return arr[0];
        }
        String prefix = arr[0];
        for(int i = 1; i < n; i++) {
            prefix = commonPrefix(prefix,arr[i]);
        }
        return prefix.length() > 0 ? prefix :"-1";
    }

    private static String commonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(),str2.length());
        String commonPrefix = "";
        for(int i = 0; i < len; i++) {
            if(str1.charAt(i) == str2.charAt(i)) {
                commonPrefix+=str1.charAt(i);
            }else {
                return commonPrefix;
            }
        }
        return commonPrefix;
    }
}
