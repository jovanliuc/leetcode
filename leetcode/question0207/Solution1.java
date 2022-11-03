package leetcode.question0207;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {

    @Test
    void test() {
        canFinish(3, new int[][]{{0,2},{1,2},{2,0}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int to = edge[0];
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                ++count;
            }
        }


        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                    ++count;
                }
            }
        }

        return count == numCourses;
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
}
