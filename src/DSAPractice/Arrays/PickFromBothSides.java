package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class PickFromBothSides {
    public static void main(String[] args) {
        ArrayList<Integer>A = new ArrayList<>(Arrays.asList(-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35 ));
        int i = A.hashCode();
        ListIterator<Integer> integerListIterator = A.listIterator(40);
        List<Integer> integers = A.subList(40, 43);
        System.out.println(integers.toString());
        while (integerListIterator.hasNext()) {
            System.out.println(integerListIterator.next());
        }
        int B = 48;
        System.out.println(solve(A,B));
    }
    public static int solve(ArrayList<Integer> A, int B) {
        int left = 0;
        int right = A.size()-1;
        int maxSum = 0;
        while(left < right && B > 0) {
            if(A.get(left) > A.get(right)) {
                maxSum+=A.get(left++);
            }else {
                maxSum+=A.get(right--);
            }
            B--;
        }
        return maxSum;
    }
}
