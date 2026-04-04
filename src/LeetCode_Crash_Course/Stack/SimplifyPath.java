package LeetCode_Crash_Course.Stack;

import java.util.ArrayList;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(new SimplifyPath().simplifyPath(path));
    }
    public String simplifyPath(String path) {
        ArrayList<String> res = new ArrayList<>();
        String[] split = path.split("/");
        for(String s: split) {
            if(s.isEmpty() || s.equals(".")) {
                continue;
            }else if(s.equals("..")) {
                if(!res.isEmpty()) {
                    res.remove(res.size()-1);
                }
            }else {
                res.add(s);
            }
        }
        return "/"+String.join("/",res);
    }
}
