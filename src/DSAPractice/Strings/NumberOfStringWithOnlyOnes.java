package DSAPractice.Strings;

public class NumberOfStringWithOnlyOnes {
    public static void main(String[] args) {
        String s = "11111100001001";
        System.out.println(numSub(s));
    }
    static double mod = 1+7;
    public static int numSub(String s) {
        int total = 0;
        int count = 0;
        for(Character c:s.toCharArray()) {
            if(c == '1') {
                count++;
            }else {
                total = (int) (total+((count*(count+1))/2)%mod);
//                total = (total+count)%mod;
                count = 0;
            }
        }
        if(s.endsWith("1")) {
            total = (int) (total + ((count * (count + 1)) / 2) % mod);
        }
        return (int) ((int) total%mod);
    }
}
