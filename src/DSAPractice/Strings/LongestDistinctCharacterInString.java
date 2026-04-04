package DSAPractice.Strings;

public class LongestDistinctCharacterInString {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestSubstrDistinctChars(s));
    }
    static int longestSubstrDistinctChars(String str){
//        int n = S.length();
//        Boolean [] freq = new Boolean[26];
//        for(int i = 0; i< 26; i++) {
//            freq[i] = false;
//        }
//        int maxLen = 0;
//        int currLen = 0,i = 0;
//        while(i < n) {
//            if(!freq[S.charAt(i)-'a']) {
//                currLen++;
//                freq[S.charAt(i)-'a'] = true;
//                i++;
//            }else {
//                maxLen = Math.max(currLen,maxLen);
//                currLen = 0;
//                int j = 0;
//                while(j < i) {
//                    freq[S.charAt(j)-'a'] = false;
//                    j++;
//                }
//            }
//        }
//        return maxLen;
//        HashSet<Character> set =  new HashSet<>();
//        int max=0;
//        int count= 0;
//        for(int i=0;i<S.length();i++){
//            for(int j= i;j<S.length();j++){
//                if(set.contains(S.charAt(j))){
//                    break;
//                }
//                set.add(S.charAt(j));
//            }
//            count = set.size();
//            max = Math.max(max,count);
//            set.removeAll(set);
//        }
//        return max;
        String test = "";

        // Result
        int maxLength = -1;

        // Return zero if string is empty
        if (str.isEmpty()) {
            return 0;
        }
        // Return one if string length is one
        else if (str.length() == 1) {
            return 1;
        }
        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);

            // If string already contains the character
            // Then substring after repeating character
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current)
                        + 1);
            }
            test = test + String.valueOf(c);
            maxLength = Math.max(test.length(), maxLength);
        }

        return maxLength;
    }
}
