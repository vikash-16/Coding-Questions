package DSAPractice.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GanerateParanthesis {
    public static void main(String[] args) {
        List<String> strings = new GanerateParanthesis().generateParenthesis(3);
        System.out.println(strings);
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String s = "";
        int open = 0, close = 0;
        backtracking(open,close,n,result,s);
        return result;

    }

    private void backtracking(int open, int close, int n, List<String> result, String s) {
        if(s.length() == 2*n){
            result.add(s);
            return;
        }
        if(open < n)
            backtracking(open+1,close,n,result,s+"(");
        if(close < open)
            backtracking(open,close+1,n,result,s+")");
    }

}
