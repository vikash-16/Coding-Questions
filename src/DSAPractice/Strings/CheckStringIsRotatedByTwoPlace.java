package DSAPractice.Strings;

public class CheckStringIsRotatedByTwoPlace {
    public static void main(String[] args) {
        String a = "amazon";
        String b = "azonam";
        System.out.println(isRotated(a,b));
    }
    public static boolean isRotated(String str1, String str2)
    {
        if(str1.length() != str2.length()) {
            return false;
        }
        int n = str1.length();
        boolean clockWiseCheck = clockWiseCheck(str1, str2, n);
        boolean antiClockWiseCheck = antiClockWiseCheck(str1, str2, n);
        return clockWiseCheck || antiClockWiseCheck ? true :false;
    }

    private static boolean antiClockWiseCheck(String str1, String str2, int n) {
        for(int i = 0; i < n; i++) {
            if(str1.charAt(i) != str2.charAt((i+n-2)%n)) {
                return false;
            }
        }
        return true;
    }

    private static boolean clockWiseCheck(String str1, String str2, int n) {
        for(int i = 0; i < n; i++) {
            if(str1.charAt(i) != str2.charAt((i+2)%n)) {
                return false;
            }
        }
        return true;
    }
}
