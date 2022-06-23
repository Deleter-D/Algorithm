package GreedyMethod;

import java.util.Arrays;

public class MultiMachineSchedulingProblem {
    public static void MultiMachine(int[] t, int[] d) {// t存储n个作业的处理时间，d存储m台机器的已占用时间
        int n = t.length, m = d.length;// m台机器，n个任务
        int[][] S = new int[m][n];// S[i]存储机器i处理作业的队列，rear[i]为队尾下标
        int[] rear = new int[m];
        int i, j, k;

        for (i = 0; i < m; i++) {// 初始化S
            for (j = 0; j < n; j++) {
                S[i][j] = -1;
            }
        }

        for (i = 0; i < m; i++) {// 安排前m个作业
            S[i][0] = i;
            rear[i] = 0;
            d[i] = t[i];
        }
        for (i = m; i < n; i++) {// 依次安排余下的作业
            for (j = 0, k = 1; k < m; k++) {// 查找最先空闲的机器
                if (d[k] < d[j])
                    j = k;
            }
            rear[j]++;
            S[j][rear[j]] = i;// 将作业i插入队列S[j]
            d[j] = d[j] + t[i];
        }
        for (i = 0; i < m; i++) {
            System.out.println("机器" + i + ":");
            for (j = 0; S[i][j] >= 0; j++) {
                System.out.println("---作业" + S[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[] t = {16, 14, 6, 5, 4, 3, 2};
        int[] d = new int[3];
        MultiMachine(t, d);
        System.out.println(Arrays.toString(d));
    }
}
