package leetcode.question0054;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    @Test
    void test() {
        spiralOrder(null);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int top = 0;
        int bottom = rowLength - 1;
        int left = 0;
        int right = colLength - 1;
        while (result.size() < rowLength * colLength) {

            if (top <= bottom) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            }

            if (left <= right) {
                for (int j = top; j <= bottom; j++) {
                    result.add(matrix[j][right]);
                }
                right--;
            }

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    result.add(matrix[j][left]);
                }
                left++;
            }
        }

        return result;
    }
}
