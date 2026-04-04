package DSAPractice.DP;

import java.nio.charset.CoderResult;

public class NumberofWaystoDivideaLongCorridor {
    public static void main(String[] args) {
        String corridor = "SS";
        System.out.println(new NumberofWaystoDivideaLongCorridor().numberOfWays(corridor));
    }
    public int numberOfWays(String corridor) {
        int mod = 1000000007;
        long res = 1;
        int j = 0, i = 0,countOfS = 0;
        for(;i < corridor.length();i++) {
            if(corridor.charAt(i) == 'S') {
                if(countOfS++ >= 2 && countOfS % 2 == 1) {
                    res = (res*(i-j)%mod)%mod;
                }
                j = i;
            }
        }
        return (countOfS == 0 || countOfS % 2 != 0) ? 0 : (int)res%mod;
    }
}
