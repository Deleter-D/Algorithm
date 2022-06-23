package GreedyMethod;

import java.util.Arrays;

public class GraphColoringProblem {
    private static int[] color;

    public static int ColorGraph(int[][] arc) {
        int k = 0;
        int n = arc.length;
        color = new int[n];
        boolean flag = true;// flag为true表示图中还有顶点未着色
        while (flag) {
            k++;
            flag = false;
            for (int i = 0; i < n; i++) {
                if (color[i] == 0) {
                    color[i] = k;// 顶点i着色k
                    if (!Ok(arc, i)) {// 发生冲突，取消着色
                        color[i] = 0;
                        flag = true;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(color));

        return k;
    }

    public static boolean Ok(int[][] arc, int i) {// 判断顶点i的着色是否发生冲突
        for (int j = 0; j < arc.length; j++) {// 考察其他所有顶点
            if (arc[i][j] == 1 && color[i] == color[j])// arc矩阵为无向图的邻接矩阵，1表示连通，0表示不连通
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arc = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0}
        };
        System.out.println(ColorGraph(arc));
    }
}
