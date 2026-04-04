package DSAPractice.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>>res = new ArrayList<>();
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates,target).toString());
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>temp = new ArrayList<>();
        CombinationSumHelper(candidates,0,0,target,temp);
        return res;
    }

    private void CombinationSumHelper(int[] candidates, int index, int currSum, int target, List<Integer> temp) {
        if(currSum > target) return;
        if(currSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int ind = index; ind < candidates.length; ind++) {
            currSum+=candidates[ind];
            temp.add(candidates[ind]);
            CombinationSumHelper(candidates, ind, currSum, target, temp);
            currSum-=candidates[ind];
            temp.remove(temp.size()-1);
        }
    }
}
