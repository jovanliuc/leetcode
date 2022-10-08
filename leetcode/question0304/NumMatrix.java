package leetcode.question0304;

public class NumMatrix {

    int[][] preNum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        preNum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++ ) {
                preNum[i + 1][j + 1] = preNum[i][j + 1] + preNum[i + 1][j] - preNum[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preNum[row2 + 1][col2 + 1] - preNum[row1][col2 + 1] - preNum[row2 + 1][col1] + preNum[row1][col1];
    }
}
