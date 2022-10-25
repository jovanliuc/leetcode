package leetcode.question0056;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {

    @Test
    void test() {
        int[][] intervals = {
                {1,3},{2,6},{8,10},{15,18}
        };
        int[][] result = merge(intervals);
        System.out.println(result.length);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        LinkedList<int[]> list = new LinkedList<>();
        list.addLast(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = list.getLast();
            if (cur[0] <= last[1]) {
                last[1] = Math.max(cur[1], last[1]);
            } else {
                list.addLast(cur);
            }
        }

        return list.toArray(new int[0][0]);
    }
}
