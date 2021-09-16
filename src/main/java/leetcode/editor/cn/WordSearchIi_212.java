package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 455 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchIi_212 {

    public static void main(String[] args) {
        Solution solution = new WordSearchIi_212().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> res = new HashSet<>();

        public List<String> findWords(char[][] board, String[] words) {
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (String word : words) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        dfs(board, visited, i, j, word, 0);
                    }
                }
            }
            return new ArrayList<>(res);
        }

        private void dfs(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
            if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
                return;
            }

            if (visited[i][j]) {
                return;
            }

            if (word.charAt(k) == board[i][j]) {
                if (k == word.length() - 1) {
                    res.add(word);
                    return;
                } else {
                    k++;
                }
            } else {
                return;
            }

            visited[i][j] = true;

            dfs(board, visited, i - 1, j, word, k);
            dfs(board, visited, i + 1, j, word, k);
            dfs(board, visited, i, j - 1, word, k);
            dfs(board, visited, i, j + 1, word, k);

            visited[i][j] = false;
        }

        public List<String> findWordsWithTrie(char[][] board, String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfsWithTrie(board, visited, i, j, "", trie);
                }
            }
            return new ArrayList<>(res);
        }

        private void dfsWithTrie(char[][] board, boolean[][] visited, int i, int j, String word, Trie trie) {
            if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
                return;
            }

            if (visited[i][j]) {
                return;
            }

            word += board[i][j];

            visited[i][j] = true;

            if (!trie.startWith(word)) {
                return;
            }

            if (trie.search(word)) {
                res.add(word);
                return;
            }

            dfsWithTrie(board, visited, i - 1, j, word, trie);
            dfsWithTrie(board, visited, i + 1, j, word, trie);
            dfsWithTrie(board, visited, i, j - 1, word, trie);
            dfsWithTrie(board, visited, i, j + 1, word, trie);

            visited[i][j] = false;
        }

        class Trie {
            TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            private void insert(String word) {
                TrieNode p = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (p.nodes[c - 'a'] == null) {
                        p.nodes[c - 'a'] = new TrieNode();
                    }
                    p = p.nodes[c - 'a'];
                }
                p.isWord = true;
            }

            private boolean startWith(String word) {
                TrieNode p = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (p.nodes[c - 'a'] == null) {
                        return false;
                    }
                    p = p.nodes[c - 'a'];
                }
                return true;
            }

            private boolean search(String word) {
                TrieNode p = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (p.nodes[c - 'a'] == null) {
                        return false;
                    }
                    p = p.nodes[c - 'a'];
                }
                return p.isWord;
            }
        }

        class TrieNode {
            boolean isWord;
            TrieNode[] nodes = new TrieNode[26];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}