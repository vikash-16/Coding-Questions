Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


solution::

class Solution {
public:
    void wordsearch(string word, queue<string>&q, unordered_map<string, bool>&mp) {

        for(int i = 0; i < word.size(); i++) {
            string w = word;
            for(int j = 0; j < 26; j++) {
                w[i] = 'a'+j;
                if(mp.find(w) != mp.end() && mp[w] == false) {
                    q.push(w);
                    mp[w] = true;
                }
            }
        }
    }
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_map<string, bool>mp;
        queue<string>q;
        int length = 1;
        for(int i = 0; i < wordList.size(); i++) {
            mp[wordList[i]] = false;
        }
        q.push(beginWord);
        mp[beginWord] = true;
        while(!q.empty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                string temp = q.front();
                q.pop();
                if(temp == endWord) {
                    return length;
                }
                wordsearch(temp, q, mp);
            }
            length++;
        }
        return 0;
    }
};
