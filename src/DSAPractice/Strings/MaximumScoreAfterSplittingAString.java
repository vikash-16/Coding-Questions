package DSAPractice.Strings;

public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        String s = "011101";
        System.out.println(new MaximumScoreAfterSplittingAString().maxScore(s));
    }
    public int maxScore(String s) {
        int length = s.length();
        char[] str = s.toCharArray();
        int [] zeroCount = new int[length];
        int [] oneCount = new int[length];
        int count1s = 0;
        int count0s = 0;
        for(int i = 0; i < length; i++) {
            if(str[i]-'0' == 0) {
                count0s++;
            }
            zeroCount[i] = count0s;
            if(str[length-i-1]-'0' == 1) {
                count1s++;
            }
            oneCount[length-1-i] = count1s;
        }
        int maxScore = zeroCount[0]+oneCount[length-1];
        for (int i = 0; i < length-1; i++) {
            maxScore = Math.max(maxScore,zeroCount[i]+oneCount[i+1]);
        }
        return maxScore;
    }
}
