package pruning;

/**
 * @author zengjia
 * @date 2021-08-20 22:19:37
 */
public class SudokuSolver_37 {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] box = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int curNum = board[i][j] - '1';
                row[i][curNum] = true;
                col[j][curNum] = true;
                int whichBox = j / 3 + (i / 3) * 3;
                box[whichBox][curNum] = true;
            }
        }
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        int curNum = c - '1';
                        int whichBox = j / 3 + (i / 3) * 3;
                        if (!row[i][curNum] && !col[j][curNum] && !box[whichBox][curNum]) {
                            row[i][curNum] = true;
                            col[j][curNum] = true;
                            box[whichBox][curNum] = true;

                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';

                                row[i][curNum] = false;
                                col[j][curNum] = false;
                                box[whichBox][curNum] = false;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
