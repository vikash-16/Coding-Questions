package DSAPractice.Arrays;

import java.util.*;

public class UsersActiveMinute {
    public static void main(String[] args) {
        int [][] logs = {{0,5},{1,2},{0,2},{0,5},{1,3}};
        int[] ints = findingUsersActiveMinutes(logs, 5);
        for(int x : ints) {
            System.out.println(x);
        }
    }
    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for(int i = 0; i < logs.length; i++) {
            if(!mp.containsKey(logs[i][0])) {
                HashSet<Integer> objects = new HashSet<>();
                objects.add(logs[i][1]);
                mp.put(logs[i][0],objects);
            }else{
                Set<Integer> integers = mp.get(logs[i][0]);
                integers.add(logs[i][1]);
                mp.replace(logs[i][0],integers);
            }
        }
        int [] result = new int [k];
        for(Set<Integer>x : mp.values()) {
            result[x.size()-1]++;
        }
        return result;
    }
    int findgcd(int a, int b){
        if(b == 0) return a;
        return findgcd(b,a%b);
    }

    String gcdOfStrings(String str1, String str2) {
        if(str1 + str2 != str2 + str1) return "";
        int gcd = findgcd(str1.length(), str2.length());
        return str1.substring(0,gcd);
    }
}
