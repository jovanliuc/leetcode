package leetcode.question0210;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private boolean[] onPath;
    private boolean[] visited;
    private boolean hasCycle;
    private List<Integer> postorder;

    @Test
    void test() {
        findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        postorder = new ArrayList<>();
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        if (hasCycle) {
            return new int[]{};
        }

        int[] result = new int[numCourses];
        Collections.reverse(postorder);
        for (int i = 0; i < numCourses; i++) {
            result[i] = postorder.get(i);
        }

        return result;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
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
        postorder.add(s);
        onPath[s] = false;
    }
}
