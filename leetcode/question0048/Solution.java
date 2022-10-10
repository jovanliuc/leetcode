package leetcode.question0048;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        rotate(null);
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                matrix[i][j] = matrix[i][j]^matrix[j][i];
                matrix[j][i] = matrix[i][j]^matrix[j][i];
                matrix[i][j] = matrix[i][j]^matrix[j][i];
            }
        }

        for (int[] row : matrix) {
            int i = 0;
            int j = row.length - 1;
            while (i < j) {
                row[i] = row[i]^row[j];
                row[j] = row[i]^row[j];
                row[i] = row[i]^row[j];
                i++;
                j--;
            }
        }
    }
}
