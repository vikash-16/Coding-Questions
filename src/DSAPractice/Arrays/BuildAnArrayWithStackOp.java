package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOp {
    public static void main(String[] args) {
        int [] target = {1,3};
        int n = 3;
        System.out.println(new BuildAnArrayWithStackOp().buildArray(target,n));
    }
    public List<String> buildArray(int[] target, int n) {
        List<String>result = new ArrayList<>();
        int i = 1;
        for(int num : target) {
            while (i < num) {
                result.add("Push");
                result.add("Pop");
                i++;
            }
            result.add("Push");
            i++;
        }
        return result;
    }
}
