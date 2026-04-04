package DSAPractice.Strings;

public class RecaursivelyRemoveAllAdjacent {
    public static void main(String[] args) {
        String str = "geeksforgeek";
        System.out.println(rremove(str));
    }
    static String rremove(String s) {
        int n = s.length();
        if(n==0 || n==1) return s;
        StringBuilder sb = new StringBuilder();
        if(s.charAt(0)!=s.charAt(1)){
            sb.append(s.charAt(0));
        }
        for(int i=1;i<n-1;i++){
            if(s.charAt(i-1)==s.charAt(i) || s.charAt(i)==s.charAt(i+1)){
                continue;
            }
            else sb.append(s.charAt(i));
        }
        if(s.charAt(n-2)!=s.charAt(n-1)){
            sb.append(s.charAt(n-1));
        }
        if(sb.length()==n){
            return sb.toString();
        }
        return rremove(sb.toString());
    }
}
