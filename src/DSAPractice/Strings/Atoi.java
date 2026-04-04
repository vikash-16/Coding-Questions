package DSAPractice.Strings;

public class Atoi {
    public static void main(String[] args) {
        String s = "-a123";
        System.out.println(atoi(s));
    }

    static int atoi(String str) {
        Boolean isNegative = false;
        int number = 0;
        try {
            number = Integer.parseInt(str);
        }catch (Exception e) {
            return -1;
        }
        return number;
    }
}
