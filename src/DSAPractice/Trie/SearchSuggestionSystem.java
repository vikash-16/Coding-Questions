package DSAPractice.Trie;


import java.time.temporal.ChronoUnit;
import java.util.*;

public class SearchSuggestionSystem {
    public static void main(String[] args) {
        String []products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String  searchWord = "mo";
        List<List<String>> lists = new SearchSuggestionSystem().suggestedProducts(products, searchWord);
        System.out.println(lists);
    }
    TrieNode root = new TrieNode();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for(String product: products) {
            insertWord(product);
        }
        List<List<String>> resultList = new ArrayList<>();
        for(int i = 0; i < searchWord.length(); i++) {
            resultList.add(new ArrayList<>());
        }
        TrieNode curr = this.root;
        for(int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            if(curr.children[c-'a'] == null) return resultList;
            curr = curr.children[c-'a'];
            Iterator<String> iterator = curr.dict.iterator();
            int count = 3;
            while (count-- > 0 && iterator.hasNext()) {
                resultList.get(i).add(iterator.next());
            }
//            curr = curr.children[c-'a'];
        }
        return resultList;
    }
    public void insertWord(String s) {
        TrieNode curr = this.root;
        for(Character c : s.toCharArray()) {
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
            curr.dict.add(s);
        }
        curr.isWord = true;
    }
}
class TrieNode {
    TrieNode [] children;
    Boolean isWord;
    Set<String> dict;
    TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
        this.dict = new TreeSet<>();
    }
}
