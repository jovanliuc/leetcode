package leetcode.question0059;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        generateMatrix(9);
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int top = 0;
        int bottom = rowLength - 1;
        int left = 0;
        int right = colLength - 1;
        int num = 1;
        while (num <= n * n) {

            if (top <= bottom) {
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = num++;
                }
                top++;
            }

            if (left <= right) {
                for (int j = top; j <= bottom; j++) {
                    matrix[j][right] = num++;;
                }
                right--;
            }

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;;
                }
                bottom--;
            }

            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    matrix[j][left] = num++;;
                }
                left++;
            }
        }

        return matrix;
    }
}
