package DynamicProgramming;

import java.util.Arrays;

public class DataTower {
    public static int Tower(int[][] d) {
        int n = d.length;
        int[][] maxAdd = new int[n][n];
        int[][] path = new int[n][n];
        int i, j;
        for (j = 0; j < n; j++) {
            maxAdd[n - 1][j] = d[n - 1][j];
        }
        for (i = n - 2; i >= 0; i--) {
            for (j = 0; j <= i; j++) {
                if (maxAdd[i + 1][j] > maxAdd[i + 1][j + 1]) {
                    maxAdd[i][j] = d[i][j] + maxAdd[i + 1][j];
                    path[i][j] = j;
                } else {
                    maxAdd[i][j] = d[i][j] + maxAdd[i + 1][j + 1];
                    path[i][j] = j + 1;
                }
            }
        }
        System.out.println("路径：" + d[0][0]);
        j = path[0][0];
        for (i = 1; i < n; i++) {
            System.out.println("-->" + d[i][j]);
            j = path[i][j];
        }
        System.out.println(Arrays.deepToString(maxAdd));
        return maxAdd[0][0];
    }

    public static void main(String[] args) {
        int[][] d = {{8}, {12, 15}, {3, 9, 6}, {8, 10, 5, 12}, {16, 4, 18, 10, 9}};
        System.out.println(Tower(d));
    }
}
