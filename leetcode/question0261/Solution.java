package leetcode.question0261;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int n = 5;
        int[][] edges = {
            {0,1},
            {0,2},
            {0,3},
            {1,4}
        };
        validTree(n, edges);
    }

    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            if (uf.connected(v, w)) {
                return false;
            }
            uf.union(v, w);
        }

        return uf.count() == 1;
    }
}
