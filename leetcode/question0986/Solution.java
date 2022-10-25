package leetcode.question0986;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    @Test
    void test() {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        intervalIntersection(firstList, secondList);
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {

            int x1 = firstList[i][0];
            int y1 = firstList[i][1];
            int x2 = secondList[j][0];
            int y2 = secondList[j][1];
            if (x1 <= y2 && x2 <= y1) {
                result.add(new int[]{Math.max(x1, x2), Math.min(y1, y2)});
            }

            if (y1 > y2) {
                j++;
            } else {
                i++;
            }
        }

        return result.toArray(new int[0][0]);
    }
}
