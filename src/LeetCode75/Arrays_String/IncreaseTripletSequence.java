package LeetCode75.Arrays_String;

public class IncreaseTripletSequence {
    public static void main(String[] args) {
        System.out.println(new IncreaseTripletSequence().increasingTriplet(new int []{1,2,3,4,5,6}));
    }
    public boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE,secondMin = Integer.MAX_VALUE;
        for(int n: nums) {
            if(n <= firstMin) firstMin = n;
            else if(n <= secondMin) secondMin = n;
            else return true;
        }
        return false;
    }
}
