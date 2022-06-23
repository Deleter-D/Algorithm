package GreedyMethod;

public class TSP {
    private static final int INFINITY = 100000;

    public static int TSP1(int[][] arc, int w) {// arc为邻接矩阵，w为出发顶点
        int edgeCount = 0, TSPLength = 0;
        int min, u, v = 0;
        int n = arc.length;
        int[] flag = new int[n];// 标记顶点是否在哈密顿回路中
        u = w;
        flag[w] = 1;
        while (edgeCount < n - 1) {// 哈密顿回路中只有n-1条边
            min = 1000;
            for (int j = 1; j < n; j++) {// 求整个邻接矩阵中的最小值
                if ((flag[j] == 0) && (arc[u][j] != 0) && (arc[u][j] < min)) {
                    v = j;
                    min = arc[u][j];
                }
            }
            TSPLength += arc[u][v];
            flag[v] = 1;// 将顶点加入哈密顿回路
            edgeCount++;
            System.out.println(u + "--->" + v);
            u = v;// 更新下次出发的顶点
        }
        System.out.println(v + "--->" + w);
        return TSPLength + arc[u][w];
    }



    public static void main(String[] args) {
        int[][] arc = {
                {INFINITY, 3, 3, 2, 6},
                {3, INFINITY, 7, 3, 2},
                {3, 7, INFINITY, 2, 5},
                {2, 3, 2, INFINITY, 3},
                {6, 2, 5, 3, INFINITY}
        };
        System.out.println(TSP1(arc, 0));
    }
}
