package leetcode.question0200;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        numIslands(grid);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        if (i < 0 || i > rowLength - 1 || j < 0 || j > colLength - 1) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
