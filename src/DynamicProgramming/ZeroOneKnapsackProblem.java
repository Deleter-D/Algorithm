package DynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapsackProblem {
    public static int KnapSack(int[] w, int[] v, int C) {// w:物品重量,v:物品价值,C:背包容量
        int i, j;
        int n = w.length;
        int[] x = new int[n];// 存放物品装入情况
        int[][] V = new int[n + 1][C + 1];// 迭代数组,含义:任取物品[0,i]放入容量为j的背包中
        for (i = 0; i <= n; i++)// 初始化第0列
            V[i][0] = 0;
        for (j = 0; j <= C; j++)// 初始化第0行
            V[0][j] = 0;
        for (i = 1; i <= n; i++)
            for (j = 1; j <= C; j++)
                if (j < w[i - 1])// 当前迭代的容量如果小于物品重量
                    V[i][j] = V[i - 1][j];// 则不放入物品，总价值与它上方的数值相同
                else// 否则，取“上方数值”和“不放物品i时的最大价值+物品i的价值”较大者
                    V[i][j] = Math.max(V[i - 1][j], V[i - 1][j - w[i - 1]] + v[i - 1]);
        for (j = C, i = n; i > 0; i--) {
            if (V[i][j] > V[i - 1][j]) {
                x[i - 1] = 1;
                j = j - w[i - 1];
            } else
                x[i - 1] = 0;
        }

        System.out.println(Arrays.toString(x));

        return V[n][C];// 返回最大价值
    }

    public static void main(String[] args) {
        int[] w = {2, 2, 6, 5, 4};
        int[] v = {6, 3, 5, 4, 6};
        int C = 10;
        System.out.println(KnapSack(w, v, C));
    }
}
