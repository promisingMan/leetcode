package pruning;

/**
 * @author zengjia
 * @date 2021-08-20 22:05:50
 */
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int curNum = board[i][j] - '1';

                if (row[i][curNum]) {
                    return false;
                }
                if (col[j][curNum]) {
                    return false;
                }
                int whichBox = j / 3 + (i / 3) * 3;
                if (box[whichBox][curNum]) {
                    return false;
                }

                row[i][curNum] = true;
                col[j][curNum] = true;
                box[whichBox][curNum] = true;
            }
        }

        return true;
    }
}
