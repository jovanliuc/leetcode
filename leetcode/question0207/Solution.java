package leetcode.question0207;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private boolean[] onPath;
    private boolean[] visited;
    private boolean hasCycle;

    @Test
    void test() {
        canFinish(3, new int[][]{{0,2},{1,2},{2,0}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    private void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            return;
        }

        onPath[s] = true;
        visited[s] = true;
        for (int v : graph[s]) {
            traverse(graph, v);
        }
        onPath[s] = false;
    }
}
