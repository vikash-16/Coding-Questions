package LeetCode75.Arrays_String;

public class StringCompression {
    public static void main(String[] args) {
        int compress = new StringCompression().compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
        System.out.println(compress);
    }
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;

        int index = 0;
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                chars[index++] = chars[i - 1];

                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[index++] = c;
                    }
                }

                count = 1;
            } else {
                count++;
            }
        }

        chars[index++] = chars[chars.length - 1];
        if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                chars[index++] = c;
            }
        }

        return index;
    }
}
