import java.util.ArrayList;
import java.util.Arrays;

public class Trie_208 {
    class Trie{
        boolean isEnd;
        Trie[] next;

        /** Initialize your data structure here. */
        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie node = this;
            char[] w = word.toCharArray();
            for (char c : w){
                if(node.next[c-'a'] == null){
                    node.next[c-'a'] = new Trie();
                }
                node = node.next[c-'a'];
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = this;
            char[] w = word.toCharArray();
            for(char c : w){
                node = node.next[c-'a'];
                if (node == null){
                    return false;
                }
            }
            return node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie node = this;
            char[] p = prefix.toCharArray();
            for(char c : p){
                node = node.next[c-'a'];
                if(node == null) return false;
            }
            return true;
        }
    }
}
