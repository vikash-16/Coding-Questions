package DSAPractice.Strings;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {
    public static void main(String[] args) {
        String s = "wreorttvosuidhrxvmvo";
        int []indices = {14,12,10,5,0,18};
        String [] sources = {"rxv","dh","ui","ttv","wreor","vo"};
        String [] targets = {"frs","c","ql","qpir","gwbeve","n"};
        System.out.println(new FindAndReplaceInString().findReplaceString(s,indices,sources,targets));
//        "gwbeveqpirosqlcfrsmn"
    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer,Integer>table = new HashMap<>();
        for(int i = 0; i < indices.length; i++) {
            if(s.startsWith(sources[i],indices[i])) {
                table.put(indices[i],i);
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length();) {
            if(table.containsKey(i)) {
                str.append(targets[table.get(i)]);
                i+=sources[table.get(i)].length();
            }else {
                str.append(s.charAt(i));
                i++;
            }
        }
        return str.toString();
    }
}
