Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]


solution::

class Solution {
public:
    unordered_map<string,vector<string>>map;
    vector<string> wordBreak(string s, vector<string>& wordDict) {

        unordered_set<string>set(wordDict.begin(),wordDict.end());
        return word(s,set);
    }
    vector<string> word(string s,unordered_set<string>set){
        if(map.count(s))return map[s];
        vector<string>res;
        if(set.count(s))
            res.push_back(s);
        for(int i = 1; i < s.size();i++){
            string lastWord = s.substr(i);
            if(set.count(lastWord)){
                vector<string>temp = word(s.substr(0,i),set);
                if(temp.size()){
                    for(int j = 0; j < temp.size();j++){
                        res.push_back(temp[j]+" "+lastWord);
                    }
                }
            }
        }
        map[s] = res;
        return res;
    }
};
