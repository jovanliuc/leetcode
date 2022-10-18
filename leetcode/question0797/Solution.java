package leetcode.question0797;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    private List<List<Integer>> result = new LinkedList<>();

    @Test
    void test() {
        allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return result;
    }

    private void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        path.offer(s);
        if (s == graph.length - 1) {
            result.add(new LinkedList<>(path));
        }
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }
        path.removeLast();
    }
}
