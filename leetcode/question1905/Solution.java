package leetcode.question1905;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int[][] grid1 = {
            {1,1,1,0,0},
            {0,1,1,1,1},
            {0,0,0,0,0},
            {1,0,0,0,0},
            {1,1,0,1,1}
        };
        int[][] grid2 = {
            {1,1,1,0,0},
            {0,0,1,1,1},
            {0,1,0,0,0},
            {1,0,1,1,0},
            {0,1,0,1,0}
        };
        countSubIslands(grid1, grid2);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if (grid1 == null || grid1.length == 0 || grid2 == null || grid2.length == 0) {
            return 0;
        }

        int rowLen = grid2.length;
        int colRow = grid2[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colRow; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colRow; j++) {
                if (grid2[i][j] == 1) {
                    result++;
                    dfs(grid2, i, j);
                }
            }
        }

        return  result;
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
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
