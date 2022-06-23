package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequenceProblem {
    public static int IncreaseOrder(int[] a) {
        int i, j, k, index;
        int n = a.length;
        int[] L = new int[n];
        int[][] x = new int[n][n];
        for (i = 0; i < n; i++) {// 初始化，最长递增子序列长度为1
            L[i] = 1;
            x[i][0] = a[i];
        }

        System.out.println("初始化完成");
        for (int[] item : x) {
            System.out.println(Arrays.toString(item));
        }

        for (i = 1; i < n; i++) {
            int max = 1;
            for (j = i - 1; j >= 0; j--) {
                if ((a[j] < a[i]) && (max < L[j] + 1)) {
                    max = L[j] + 1;
                    L[i] = max;
                    for (k = 0; k < max - 1; k++) {
                        x[i][k] = x[j][k];
                    }
                    x[i][max - 1] = a[i];
                }
            }
        }
        for (index = 0, i = 1; i < n; i++) {// 求所有递增子序列的最大长度
            if (L[index] < L[i])
                index = i;
        }
        System.out.println("最长子序列：");
        for (i = 0; i < L[index]; i++) {// 输出最长递增子序列
            System.out.println(x[index][i]);
        }

        for (int[] item : x) {
            System.out.println(Arrays.toString(item));
        }

        return L[index];// 返回最长递增子序列的长度
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 8, 6, 3, 6, 9, 7};
        System.out.println(IncreaseOrder(a));
    }
}
