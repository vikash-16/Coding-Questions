package DSAPractice.Strings;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    public static void main(String[] args) {
        String []queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";
        System.out.println(new CamelcaseMatching().camelMatch(queries,pattern));
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean>result = new ArrayList<>();
        for(String query : queries) {
            Boolean b = checkCamelMatched(query.toCharArray(), pattern.toCharArray());
            result.add(b);
        }
        return result;
    }

    private Boolean checkCamelMatched(char[] query, char[] pattern) {
        int j = 0;
        for(int i = 0; i < query.length; i++) {
            if(j < pattern.length && query[i] == pattern[j]) {
                j++;
            }else if(Character.isUpperCase(query[i])) {
                return false;
            }
        }
        return j == pattern.length;
    }
}
