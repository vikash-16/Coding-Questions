package DSAPractice.Arrays;

public class NumberOfLeasserBeamsInBanks {
    public static void main(String[] args) {
       String[] bank = {"111111","011001","000000","010100","001000"};
        System.out.println(numberOfBeams(bank));
    }
    public static int numberOfBeams(String[] bank) {
        int m = bank.length; int n =  bank[0].length();
        int count = 0,totalCount = 0,prev =  0;
        for(int i = 0; i < m; i++) {
            count = 0;
            for(int j = 0; j < n; j++) {
                if(bank[i].charAt(j) == '1') {
                    count++;
                }
            }
            if(count > 0) {
                totalCount+= prev * count;
                prev = count;
            }
        }
        return totalCount;
    }

}
