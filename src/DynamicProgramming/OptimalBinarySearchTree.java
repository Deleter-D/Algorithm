package DynamicProgramming;

public class OptimalBinarySearchTree {
    public static double OptimalBST(double[] p) {
        int i, j, k, d;
        double min, mink, sum;
        int n = p.length;
        double[][] C = new double[n + 1][n + 1];
        double[][] R = new double[n + 1][n + 1];
        for (i = 1; i <= n; i++) {
            C[i][i - 1] = 0;
            C[i][i] = p[i - 1];
            R[i][i] = i;
        }
        C[n + 1][n] = 0;
        for (d = 1; d < n; d++) {
            for (i = 1; i <= n; i++) {
                j = i + d;
                min = 1000;
                mink = i;
                sum = 0;
                for (k = i; k <= j; k++) {
                    sum += p[k + 1];
                    if (C[i][k - 1] + C[k + 1][j] < min) {
                        min = C[i][k - 1] + C[k + 1][j];
                        mink = k;
                    }
                }
                C[i][j] = min + sum;
                R[i][j] = mink;
            }
        }
        return C[1][n];
    }

    public static void main(String[] args) {
        double[] p = {0.1, 0.2, 0.4, 0.3};
        System.out.println(OptimalBST(p));
    }
}
