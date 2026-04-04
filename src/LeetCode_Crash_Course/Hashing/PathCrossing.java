package LeetCode_Crash_Course.Hashing;

import java.util.HashSet;

public class PathCrossing {
    public static void main(String[] args) {
        String path = "NESWW";
        System.out.println(isPathCrossing(path));
    }
    public static boolean isPathCrossing(String path) {
        HashSet<String>uniquePaths = new HashSet<>();
        uniquePaths.add("0*0");
        int src = 0,dest = 0;
        for(Character c : path.toCharArray()) {
            switch (c) {
                case 'N' : src += -1;
                break;
                case 'E': dest+=1;
                break;
                case 'W': dest+=-1;
                break;
                case 'S': src+=1;
                break;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(src);
            sb.append('*');
            sb.append(dest);
            if(uniquePaths.contains(sb.toString())) {
                return true;
            }
            uniquePaths.add(sb.toString());
        }
        return false;
    }
}
