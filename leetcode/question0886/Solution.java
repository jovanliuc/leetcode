package leetcode.question0886;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private boolean[] color;
    private boolean[] visited;
    private boolean isBipartite;

    @Test
    void test() {
        int[][] disables = new int[][]{{1,2},{1,3},{2,4}};
        possibleBipartition(4, disables);
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = buildGraph(n, dislikes);
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        isBipartite = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }

        return isBipartite;
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            int v = edge[1];
            int w = edge[0];
            graph[v].add(w);
            graph[w].add(v);
        }
        return graph;
    }

    private void traverse(List<Integer>[] graph, int s) {
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
