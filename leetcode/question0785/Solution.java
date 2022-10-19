package leetcode.question0785;

import org.junit.jupiter.api.Test;

public class Solution {

    private boolean[] color;
    private boolean[] visited;
    private boolean isBipartite;

    @Test
    void test() {
        isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}});
    }

    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        color = new boolean[length];
        visited = new boolean[length];
        isBipartite = true;

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }

        return isBipartite;
    }

    private void traverse(int[][] graph, int s) {
        if (!isBipartite) {
            return;
        }

        visited[s] = true;
        for (int v : graph[s]) {
            if (!visited[v]) {
                color[v] = !color[s];
                traverse(graph, v);
            } else {
                if (color[v] == color[s]) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}
