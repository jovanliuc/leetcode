package leetcode.question0323;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int n = 5;
        int[][] edges = {
            {0,2},
            {1,2},
            {2,3},
            {3,4}
        };
        countComponents(n, edges);
    }

    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            uf.union(v, w);
        }
        return uf.count();
    }
}
