package leetcode.question0743;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {

    @Test
    void test() {
        int[][] times = {
            {2,1,1},{2,3,1},{3,4,1}
        };
        int n = 4;
        int k = 2;
        networkDelayTime(times, n, k);
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[] {to, weight});
        }

        int[] distTo = dijkstra(graph, k);
        int result = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, distTo[i]);
         }

        return result;
    }

    int[] dijkstra(List<int[]>[] graph, int start) {
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;

        Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.distFromStart));
        queue.offer(new State(start, 0));
        while (!queue.isEmpty()) {
            State curState = queue.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }

            for (int[] neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                int distToNextNode = distTo[curNodeID] + neighbor[1];

                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    queue.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }

        return distTo;
    }
}
