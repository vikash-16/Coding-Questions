package DSAPractice.Arrays;

public class LastMomentBeforeAllAntsFallOutofaPlank {
    public static void main(String[] args) {
        int []left = {4,7,15};
        int []right = {9,3,13,10};
        System.out.println(new LastMomentBeforeAllAntsFallOutofaPlank().getLastMoment(20,left,right));
    }
    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        for(int i = 0; i < left.length; i++) {
            leftMax = Math.max(leftMax,left[i]);
        }
        for(int i = 0; i < right.length; i++) {
            rightMax = Math.max(rightMax,n-right[i]);
        }
        return Math.max(leftMax,rightMax);
    }
}
