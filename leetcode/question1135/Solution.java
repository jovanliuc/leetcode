package leetcode.question1135;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    @Test
    void test() {
        int n = 3;
        int[][] edges = {
            {1,2,5},
            {1,3,6},
            {2,3,1}
        };
        minimumCost(n, edges);
    }

    public int minimumCost(int n, int[][] connections) {
        UF uf = new UF(n + 1);
        Arrays.sort(connections, Comparator.comparingInt(x -> x[2]));
        int mst = 0;
        for (int[] edge : connections) {
            int v = edge[0];
            int w = edge[1];
            int weight = edge[2];

            if (uf.connected(v, w)) {
                continue;
            }

            mst += weight;
            uf.union(v, w);
        }

        return uf.count() == 2 ? mst : -1;
    }
}
