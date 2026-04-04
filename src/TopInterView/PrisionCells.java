package TopInterView;

import java.util.Arrays;
import java.util.HashMap;

public class PrisionCells {
    public static void main(String[] args) {
        int[]cells = {0,1,0,1,1,0,0,1};
        int n = 7;
        int[] ints = prisonAfterNDays(cells, n);
        for(int a : ints) {
            System.out.println(a);
        }
    }
    public static int[] prisonAfterNDays(int[] cells, int n) {
        HashMap<String,Integer>seen = new HashMap<>();
        int count = 1;
        while (n > count) {
            int [] cell2 = new int [8];
            seen.put(Arrays.toString(cells),count);
            for(int i = 1; i < 7; i++) {
                cell2[i] = cells[i-1] == cells[i+1]?1:0;
            }
            cells = cell2;
            if(seen.containsKey(Arrays.toString(cells))) {
                n%= seen.get(Arrays.toString(cells));
            }
        }
        return cells;
    }
}
