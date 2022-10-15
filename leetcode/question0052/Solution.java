package leetcode.question0052;

import org.junit.jupiter.api.Test;

public class Solution {

    private int total = 0;

    @Test
    void test() {
        totalNQueens(4);
    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        initBoard(board);
        backtrack(board, 0);
        return total;
    }

    private void initBoard(char[][] board) {
        int rowLength = board.length;
        int colLength = board[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                board[i][j] = '.';
            }
        }
    }

    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            total += 1;
            return;
        }

        int colLength = board[row].length;
        for (int i = 0; i < colLength; i++) {
            if (!isValidCell(board, row, i)) {
                continue;
            }

            board[row][i] = 'Q';
            backtrack(board, row + 1);
            board[row][i] = '.';
        }
    }

    private boolean isValidCell(char[][] board, int row, int col) {
        int colLength = board[row].length;

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >=0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < colLength; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
