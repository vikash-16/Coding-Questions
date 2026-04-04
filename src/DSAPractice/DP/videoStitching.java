package DSAPractice.DP;

import java.util.Arrays;

public class videoStitching {
    public static void main(String[] args) {
        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int time = 10;
        System.out.println(new videoStitching().videoStitching(clips,time));
    }
    public int videoStitching(int[][] clips, int time) {
       int count = 0;
       for(int st = 0, ed = 0; ed < time;st = ed,count++) {
           for(int i = 0; i < clips.length; i++) {
               if(clips[i][0] <= st && clips[i][1] > ed) {
                   ed = clips[i][1];
               }
           }
           if(st == ed) return -1;
       }
       return count;
    }
}
