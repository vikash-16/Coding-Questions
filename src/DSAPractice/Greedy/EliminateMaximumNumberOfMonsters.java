package DSAPractice.Greedy;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {
    public static void main(String[] args) {
        int [] dist = {3,5,7,4,5}, speed = {2,3,6,3,2};
        System.out.println(new EliminateMaximumNumberOfMonsters().eliminateMaximum(dist,speed));
    }
    public int eliminateMaximum(int[] dist, int[] speed) {
        int [] cityTime = new int[dist.length];
        for(int i = 0; i < dist.length; i++) {
            cityTime[i] = (int)Math.ceil((double)dist[i]/speed[i]);
        }
        Arrays.sort(cityTime);
        int ans = 0;
        for(int i = 0; i < cityTime.length; i++) {
            if(cityTime[i] <= i) {
                break;
            }
            ans++;
        }
        return ans;
    }
}
