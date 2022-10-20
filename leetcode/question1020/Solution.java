package leetcode.question1020;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int[][] grid = {
            {0,0,0,0},
            {1,0,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };
        numEnclaves(grid);
    }

    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, colLen - 1);
        }
        for (int j = 0; j < colLen; j++) {
            dfs(grid, 0, j);
            dfs(grid, rowLen - 1, j);
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(int[][] grid, int i, int j) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (i < 0 || i > rowLen - 1 || j < 0 || j > colLen - 1) {
            return;
        }

        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
