package DSAPractice.Strings;

import java.util.Arrays;

public class SortCharactersByFrequency {
    public class Frequency {
        int count;
        Character c;
        Frequency(char c, int count) {
            this.count = count;
            this.c = c;
        }
    }
    public String frequencySort(String s) {
        Frequency [] frequencies = new Frequency[128];
        for(int i = 0; i < 128; i++) {
            frequencies[i] = new Frequency('a',0);
        }
        for(char c: s.toCharArray()) {
            frequencies[c-0].c = c;
            frequencies[c-0].count++;
        }
        Arrays.sort(frequencies,(a,b)->b.count-a.count);
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 128; i++) {
            if(frequencies[i].count > 0) {
                for(int j = 0; j < frequencies[i].count; j++) {
                    str.append(frequencies[i].c);
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(new SortCharactersByFrequency().frequencySort(s));
    }
}

