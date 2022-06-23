package DynamicProgramming;

import DynamicProgramming.utils.Graph;

import java.util.Arrays;

public class MultiSegmentGraphShortestPathProblem {
    private static final int MAX = 1000;

    public static int BackPath(Graph graph) {
        int n = graph.getVnum();
        int i, j, temp;
        int[] cost = new int[n];
        int[] path = new int[n];
        for (i = 1; i < n; i++) {// 初始化路径为∞
            cost[i] = MAX;
            path[i] = -1;
        }
        cost[0] = 0;// 0为源点
        path[0] = -1;
        for (j = 1; j < n; j++) {// 填表
            for (i = j - 1; i >= 0; i--) {// 考察所有入边
                if (graph.getMatrix()[i][j] >= 0)// 如果边存在
                    if (graph.getMatrix()[i][j] + cost[i] < cost[j]) {
                        cost[j] = graph.getMatrix()[i][j] + cost[i];
                        path[j] = i;
                    }
            }
        }
        System.out.println("-----" + (n - 1));// 输出终点
        i = n - 1;
        while (path[i] >= 0) {// 依次输出path[i]
            System.out.println("-----" + path[i]);
            i = path[i];// 路径上顶点i的前一个顶点
        }
        System.out.println(Arrays.toString(cost));
        return cost[n - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {-1, 4, 2, 3, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 9, 8, -1, -1, -1, -1},
                {-1, -1, -1, -1, 6, 7, 8, -1, -1, -1},
                {-1, -1, -1, -1, -1, 4, 7, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, 5, 6, -1},
                {-1, -1, -1, -1, -1, -1, -1, 8, 6, -1},
                {-1, -1, -1, -1, -1, -1, -1, 6, 5, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, 7},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, 3},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
        Graph graph = new Graph(10, 18, matrix);
        System.out.println(BackPath(graph));
    }
}
