package DSAPractice.DP;

import java.util.Arrays;

public class KnightDialer {
    public static void main(String[] args) {
        System.out.println(new KnightDialer().knightDialer(3));
    }
    public int knightDialer(int n) {
        int mod = 1000000007;
        if(n == 1) return 10;
        long []digit = new long[10];
        long [] moves = new long[10];
        Arrays.fill(moves,1);
        moves[5] = 0;
        for(int i = 1; i < n; i++) {
            digit[0] = (moves[4]+moves[6])%mod;
            digit[1] = (moves[6]+moves[8])%mod;
            digit[2] = (moves[7]+moves[9])%mod;
            digit[3] = (moves[4]+moves[8])%mod;
            digit[4] = (moves[0]+moves[3]+moves[9])%mod;
            digit[6] = (moves[0]+moves[1]+moves[7])%mod;
            digit[7] = (moves[2]+moves[6])%mod;
            digit[8] = (moves[1]+moves[3])%mod;
            digit[9] = (moves[2]+moves[4])%mod;
            for(int j = 0; j < 10; j++) {
                 moves[j] = digit[j];
            }
        }
        long count = 0;
        for(int i = 0; i < 10; i++) {
            count = (count+moves[i])%mod;
        }
        return (int)count;
    }
}
