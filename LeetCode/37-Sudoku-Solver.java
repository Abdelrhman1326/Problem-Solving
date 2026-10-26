class Solution {
    private boolean validate(char[][] board, int i, int j, char num) {
        // validate row and col:
        for (int m = 0; m < 9; m++) {
            if (board[m][j] == num) return false;
            if (board[i][m] == num) return false;
        }
        // validate 3 * 3 box:
        int rowStart = (i / 3) * 3;
        int colStart = (j / 3) * 3;

        for (int m = rowStart; m < rowStart + 3; m++) {
            for (int n = colStart; n < colStart + 3; n++) {
                if (board[m][n] == num) return false;
            }
        }

        return true;
    }
    private boolean db[][][] = new boolean[9][9][9];
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k < 10; k++) {
                        if (validate(board, i, j, (char)(k + '0')) == true) {
                            board[i][j] = (char)(k + '0');
                            boolean solveable;
                            if (db[i][j][k - 1] == true) solveable = true;
                            else solveable = solve(board);
                            if (solveable) {
                                db[i][j][k - 1] = true;
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (board[i][j] == (char)(k + '0')) {
                        db[i][j][k] = true;
                        continue;
                    }
                    db[i][j][k] = false;
                }
            }
        }
        solve(board);
    }
}