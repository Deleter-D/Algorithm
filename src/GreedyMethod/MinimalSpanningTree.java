package GreedyMethod;

import GreedyMethod.utils.ShortEdge;

public class MinimalSpanningTree {
    private static final int INFINITY = 1000;

    public static void Prim(int[][] arc, int w) {// 从顶点w出发，初始集合U={}
        int i, j, k = 0;
        int min;
        int n = arc.length;
        ShortEdge[] shortEdges = new ShortEdge[n];// 存储候选的边集合
        for (i = 0; i < n; i++) {
            shortEdges[i] = new ShortEdge();
        }
        for (i = 0; i < n; i++) {// 初始化辅助数组
            shortEdges[i].setLowcost(arc[w][i]);
            shortEdges[i].setAdjvex(w);
        }
        shortEdges[w].setLowcost(0);// 将顶点w加入集合U
        for (i = 0; i < n - 1; i++) {
            min = 1000;// 设权值不超过1000
            for (j = 0; j < n; j++) {// 寻找最短边的邻接点k
                if ((shortEdges[j].getLowcost() != 0) && (shortEdges[j].getLowcost() < min)) {
                    min = shortEdges[j].getLowcost();
                    k = j;
                }
            }
            System.out.println(shortEdges[k].getAdjvex() + "---" + k);// 输出最小生成树的边
            shortEdges[k].setLowcost(0);// 将顶点k加入集合U中
            for (j = 0; j < n; j++) {// 调整数组shortEdge[n]
                if (arc[k][j] < shortEdges[j].getLowcost()) {
                    shortEdges[j].setLowcost(arc[k][j]);
                    shortEdges[j].setAdjvex(k);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arc = {
                {0, 34, 46, INFINITY, INFINITY, 19},
                {34, 0, INFINITY, INFINITY, 12, INFINITY},
                {46, INFINITY, 0, 17, INFINITY, 25},
                {INFINITY, INFINITY, 17, 0, 38, 25},
                {INFINITY, 12, INFINITY, 38, 0, 26},
                {19, INFINITY, 25, 25, 26, 0}
        };
        Prim(arc, 0);
    }
}
