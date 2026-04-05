package LeetCode75.Arrays_String;

import java.util.ArrayDeque;
import java.util.Queue;

public class PredictPartyVictory {
    public static void main(String[] args) {
        String string = new PredictPartyVictory().predictPartyVictory("RD");
        System.out.println(string);
    }
    public String predictPartyVictory(String senate) {
        Queue<Integer>red = new ArrayDeque<>();
        Queue<Integer>dir = new ArrayDeque<>();
        for(int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R') {
                red.add(i);
            }else {
                dir.add(i);
            }
        }
        int n = senate.length();
        while(!red.isEmpty() && !dir.isEmpty()) {
            if(red.peek() < dir.peek()) {
                red.add(n++);
            }else {
                dir.add(n++);
            }
            dir.poll();
            red.poll();
        }
        return red.isEmpty()?"Dire":"Radiant";
    }
}
