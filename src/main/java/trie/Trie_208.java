package trie;

public class Trie_208 {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie_208() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.trieNodes[c - 'a'] == null) {
                p.trieNodes[c - 'a'] = new TrieNode();
            }
            p = p.trieNodes[c - 'a'];
        }
        p.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.trieNodes[c - 'a'] == null) {
                return false;
            }
            p = p.trieNodes[c - 'a'];
        }
        return p.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (p.trieNodes[c - 'a'] == null) {
                return false;
            }
            p = p.trieNodes[c - 'a'];
        }
        return true;
    }

    public static class TrieNode {
        boolean isWord;
        TrieNode[] trieNodes = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */