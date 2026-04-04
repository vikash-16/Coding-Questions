package LeetCode_Crash_Course.Hashing;

public class MaximumNumberOfBallons {
    public static void main(String[] args) {
        String text = "nlaebolko";
        System.out.println(maxNumberOfBalloons(text));
    }
    public static int maxNumberOfBalloons(String text) {
        int [] dict = new int [26];
        for(char c : text.toCharArray()) {
            dict[c-'a']++;
        }
        int minCount = Integer.MAX_VALUE;
        minCount = Math.min(minCount,dict[0]);
        minCount = Math.min(minCount,dict[1]);
        minCount = Math.min(minCount,dict[11]/2);
        minCount = Math.min(minCount,dict[14]/2);
        minCount = Math.min(minCount,dict[13]);
        return minCount;
    }
}
