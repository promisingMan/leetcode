package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zengjia
 * @date 2021-08-23 22:10:45
 */
public class WordSearchII_212 {
    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie_208 trie = new Trie_208();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                dfs(board, visited, x, y, "", trie);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, boolean[][] visited, int x, int y, String word, Trie_208 trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        word += board[x][y];
        if (!trie.startsWith(word)) {
            return;
        }

        if (trie.search(word)) {
            res.add(word);
        }

        visited[x][y] = true;

        dfs(board, visited, x - 1, y, word, trie);
        dfs(board, visited, x + 1, y, word, trie);
        dfs(board, visited, x, y - 1, word, trie);
        dfs(board, visited, x, y + 1, word, trie);

        visited[x][y] = false;
    }
}
