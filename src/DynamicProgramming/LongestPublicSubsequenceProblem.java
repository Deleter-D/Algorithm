package DynamicProgramming;

public class LongestPublicSubsequenceProblem {
    private static int CommonOrder(char[] x, char[] y) {
        int i, j, k;
        int n = y.length, m = x.length;
        char[] Z = new char[Math.max(n, m)];// 存储最长公共子序列
        int[][] DP = new int[m + 1][n + 1];// 长度矩阵
        int[][] S = new int[m + 1][n + 1];// 状态矩阵
        for (j = 0; j <= n; j++)// 初始化第0行
            DP[0][j] = 0;
        for (i = 0; i <= m; i++)// 初始化第0列
            DP[i][0] = 0;
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                if (x[i - 1] == y[j - 1]) {// 情况①：两字符相同，此处i和j减一是因为矩阵中前面要留出一个空字符的位置，对应到原字符串中就需要减一
                    DP[i][j] = DP[i - 1][j - 1] + 1;// 左上方的数字+1填入
                    S[i][j] = 1;
                } else if (DP[i][j - 1] >= DP[i - 1][j]) {// 情况②：两字符不同，且左侧的数>=上方的数
                    DP[i][j] = DP[i][j - 1];// 填入左侧数字
                    S[i][j] = 2;
                } else {// 情况③：两数字不同，且左侧的数<上方的数
                    DP[i][j] = DP[i - 1][j];// 填入上方数字
                    S[i][j] = 3;
                }
        i = m;
        j = n;
        k = DP[m][n];// 从长度矩阵的最后一个元素开始回溯
        while (i > 0 && j > 0) {
            if (S[i][j] == 1) {// 情况①：往左上方回溯，同时记录当前字符
                Z[k] = x[i - 1];
                k--;
                i--;
                j--;
            } else if (S[i][j] == 2) {// 情况②：往左侧回溯
                j--;
            } else {// 情况③：往上方回溯
                i--;
            }
        }

        for (k = 1; k <= DP[m][n]; k++) {
            System.out.println(Z[k]);
        }

        return DP[m][n];
    }

    public static void main(String[] args) {
        String strX = "abcbdb";
        char[] x = strX.toCharArray();
        String strY = "acbbabdbb";
        char[] y = strY.toCharArray();
        System.out.println(CommonOrder(x, y));
    }
}
