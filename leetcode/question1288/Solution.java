package leetcode.question1288;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    @Test
    void test() {
        int[][] intervals = {
            {1, 4}, {3, 6}, {1, 5}, {2, 8}
        };
        removeCoveredIntervals(intervals);
    }

    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }

        int len = intervals.length;
        if (intervals.length < 2) {
            return len;
        }

        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0]) {
                return y[1] - x[1];
            }
            return x[0] - y[0];
        });

        int result = 0;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < len; i++) {
            int[] interval = intervals[i];
            if (left <= interval[0] && right >= interval[1]) {
                result++;
            } else if (right >= interval[0] && right <= interval[1]) {
                right = interval[1];
            } else if (right < interval[1]) {
                left = interval[0];
                right = interval[1];
            }
        }

        return len - result;
    }
}
