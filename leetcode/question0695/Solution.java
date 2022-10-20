package leetcode.question0695;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int[][] grid = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        maxAreaOfIsland(grid);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                result = Math.max(dfs(grid, i, j), result);
            }
        }

        return result;
    }

    private int dfs(int[][] grid, int i, int j) {
       int rowLen = grid.length;
       int colLen = grid[0].length;
       if (i < 0 || i > rowLen - 1 || j < 0 || j > colLen - 1) {
           return 0;
       }
       if (grid[i][j] == 0) {
           return 0;
       }
       grid[i][j] = 0;

       return dfs(grid, i - 1, j) +
               dfs(grid, i + 1, j) +
               dfs(grid, i, j - 1) +
               dfs(grid, i, j + 1) +
               1;
    }
}
