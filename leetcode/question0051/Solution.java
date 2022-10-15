package leetcode.question0051;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<String>> result = new ArrayList<>();

    @Test
    void test() {
        solveNQueens(2);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        initBoard(board);
        backtrack(board, 0);
        return result;
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
            result.add(array2List(board));
            return;
        }

        int length = board[row].length;
        for (int i = 0; i < length; i++) {
            if (!isValidCell(board, row, i)) {
                continue;
            }

            board[row][i] = 'Q';
            backtrack(board, row + 1);
            board[row][i] = '.';
        }
    }

    private List<String> array2List(char[][] board) {
        List<String> list = new ArrayList<>();
        int rowLength = board.length;
        int colLength = board[0].length;
        for (int i = 0; i < rowLength; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < colLength; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
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
