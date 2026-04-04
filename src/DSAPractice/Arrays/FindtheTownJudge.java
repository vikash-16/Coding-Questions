package DSAPractice.Arrays;

public class FindtheTownJudge {
    public static void main(String[] args) {
        int n = 3;
        int [][]trust = {{1,3},{2,3}};
        System.out.println(new FindtheTownJudge().findJudge(n,trust));
    }
    public int findJudge(int n, int[][] trust) {
        int [] trusting = new int [n];
        int [] trusted = new int[n];
        for(int [] node : trust) {
            trusting[node[0]-1]++;
            trusted[node[1]-1]++;
        }
        for(int i = 0; i < n; i++) {
            if(trusting[i] == 0 && trusted[i] == n-1) {
                return i+1;
            }
        }
        return -1;
    }
}
