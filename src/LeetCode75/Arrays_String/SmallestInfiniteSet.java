package LeetCode75.Arrays_String;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SmallestInfiniteSet {
    SortedSet<Integer> s;
    public SmallestInfiniteSet() {
        s = new TreeSet<>();
        for(int i = 1; i <=1000; i++) {
            s.add(i);
        }
    }

    public int popSmallest() {
        Integer i = s.removeFirst();
        return i;
    }

    public void addBack(int num) {
        if(!s.contains(num)) {
            s.add(num);
        }
    }
}
