package DynamicProgramming;

import DynamicProgramming.utils.Graph;

import java.util.Arrays;

public class Floyd {
    private static final int INFINITY = 1000;
    public static int[][] FloydAlgorithm(Graph graph) {
        int i, j, k;
        int n = graph.getVnum();
        int[][] dist = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                dist[i][j] = graph.getMatrix()[i][j];
            }
        }
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (i != j && i != k && k != j)
                        if (dist[i][k] + dist[k][j] < dist[i][j])
                            dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 4, 11},
                {6, 0, 2},
                {3, INFINITY, 0}
        };
        Graph graph = new Graph(3, 5, matrix);
        for (int[] line : FloydAlgorithm(graph)) {
            System.out.println(Arrays.toString(line));
        }
    }
}
