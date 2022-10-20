package leetcode.question0694;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Solution {

    @Test
    void test() {
        int[][] grid = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}
        };
        numDistinctIslands(grid);
    }

    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        HashSet<String> islands = new HashSet<>();
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, 0, sb);
                    islands.add(sb.toString());
                }
            }
        }

        return  islands.size();
    }

    private void dfs(int[][] grid, int i, int j, int direction, StringBuilder sb) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (i < 0 || i > rowLen - 1 || j < 0 || j > colLen - 1 || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        sb.append(direction).append(",");
        dfs(grid, i + 1, j, 1, sb);
        dfs(grid, i - 1, j, 2, sb);
        dfs(grid, i, j - 1, 3, sb);
        dfs(grid, i, j + 1, 4, sb);
        sb.append(-direction).append(",");
    }
}
