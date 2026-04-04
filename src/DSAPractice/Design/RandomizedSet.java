package DSAPractice.Design;

import java.util.*;

class RandomizedSet {
    public static void main(String[] args) {

    }
    Map<Integer,Integer>freq;
    List<Integer> list;
    Random random;
    public RandomizedSet() {
        this.freq = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if(freq.containsKey(val)) return false;
        list.add(val);
        freq.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!freq.containsKey(val)) return false;
        Integer valIndex = freq.get(val);
        int lastIndex = list.size() - 1;
        if(valIndex != lastIndex) {
            Integer lastVal = list.get(lastIndex);
            freq.put(lastVal,valIndex);
            list.set(valIndex,lastVal);
        }
        list.remove(lastIndex);
        freq.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
