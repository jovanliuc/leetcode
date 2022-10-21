package leetcode.question1584;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {

    @Test
    void test() {
        int[][] points = {
            {0,0},{2,2},{3,10},{5,2},{7,0}
        };
        minCostConnectPoints(points);
    }

    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                edges.add(new int[]{i, j, Math.abs(x1 - x2) + Math.abs(y1 - y2)});
            }
        }
        Collections.sort(edges, Comparator.comparingInt(x -> x[2]));

        int mst = 0;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            int weight = edge[2];

            if (uf.connected(v, w)) {
                continue;
            }

            mst += weight;
            uf.union(v, w);
        }

        return uf.count() == 1 ? mst : -1;
    }
}
