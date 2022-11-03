package leetcode.question1514;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int n = 5;
        int[][] edges = {{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}};
        double[] succProb = {0.37,0.17,0.93,0.23,0.39,0.04};
        int start = 3;
        int end = 4;
        double res = maxProbability(n, edges, succProb, start, end);
        System.out.println(res);
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[][] matrix = new double[n][n];
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            matrix[from][to] = weight;
            matrix[to][from] = weight;
        }
        return floyd(n, matrix, start, end);
    }

    private double floyd(int n, double[][] matrix, int start, int end) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    double res = matrix[i][k] * matrix[k][j];
                    if (matrix[i][j] < res) {
                        matrix[i][j] = res;
                        matrix[j][i] = res;
                    }
                }
            }
        }

        return matrix[start][end];
    }
}
