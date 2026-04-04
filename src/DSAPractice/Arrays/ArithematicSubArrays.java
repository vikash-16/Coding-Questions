package DSAPractice.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithematicSubArrays {
    public static void main(String[] args) {
        int [] nums = {4,6,5,9,3,7};
        int []l = {0,0,2};
        int []r = {2,3,5};
        List<Boolean> booleans = checkArithmeticSubarrays(nums, l, r);
        booleans.stream().forEach(value->{
            System.out.println(value);
        });

    }
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean>result = new ArrayList<>();
        for(int i = 0; i < l.length; i++) {
            int[] ints = Arrays.copyOfRange(nums, l[i], r[i]+1);
            result.add(isArithematicSequence(ints));
        }
        return result;
    }

    private static Boolean isArithematicSequence(int[] ints) {
        if(ints.length <= 2) {
            return true;
        }
        Arrays.sort(ints);
        for(int i = 1; i < ints.length-1; i++) {
            if(ints[i]-ints[i-1] != ints[i+1]-ints[i]) {
                return false;
            }
        }
        return true;
    }
}
