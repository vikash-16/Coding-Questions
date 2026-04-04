package DSAPractice.DP;

public class NumberOfWaysToSselectBuilding {
    public static void main(String[] args) {
        String s = "001101";
        System.out.println(numberOfWays(s));
    }
    public static long numberOfWays(String s) {
        long zero = 0,zeroOne = 0,one = 0,oneZero = 0,total = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') {
                zero++;
                oneZero+=one;
                total+=zeroOne;
            }else {
                one++;
                zeroOne+=zero;
                total+=oneZero;
            }
        }
        return total;
    }
}
