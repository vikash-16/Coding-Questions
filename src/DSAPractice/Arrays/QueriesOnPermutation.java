package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.List;

public class QueriesOnPermutation {
    public static void main(String[] args) {
        int[] queries = {4,1,2,2};
        int m = 4;
        int[] ints = processQueries(queries, m);
        for(int x: ints) {
            System.out.println(x);
        }
    }
    public static int[] processQueries(int[] queries, int m) {
        int []res = new int[queries.length];
        List<Integer> p = new ArrayList<>();
        for(int i = 1; i <= m; i++) {
            p.add(i);
        }
        for(int i = 0; i < queries.length; i++) {
            int query = queries[i];
            res[i] = p.indexOf(query);
            p.remove(res[i]);
            p.add(0,queries[i]);
        }
        return res;
    }
}
