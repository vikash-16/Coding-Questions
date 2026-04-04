package DSAPractice.DP;

import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        int [] startTime = {1,2,3,3}, endTime = {3,4,5,6}, profit = {50,10,40,70};
        System.out.println(new MaximumProfitInJobScheduling().jobScheduling(startTime,endTime,profit));
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for(int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(jobs,(a,b)->(a.endTime-b.endTime));
        int [] dp = new int[n];
        dp[0] = jobs[0].profit;
        for(int i = 1; i < n; i++) {
            int maxProfit = jobs[i].profit;
            int index = binarySerchHelper(jobs, i);
            if(index != -1) {
                maxProfit +=dp[index];
            }
            dp[i] = Math.max(maxProfit,dp[i-1]);
        }
        return dp[n-1];
    }

    private int binarySerchHelper(Job[] jobs, int index) {
        int start = 0, end = index-1;
        while (start <= end) {
            int mid = start+(end-start)/2;
            if(jobs[mid].endTime <= jobs[index].startTime) {
                if(jobs[mid+1].endTime <= jobs[index].startTime) {
                    start =  mid +1;
                }else {
                    return mid;
                }
            }else {
                end = mid-1;
            }
        }
        return -1;
    }

    private class Job {
        int startTime,endTime,profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
