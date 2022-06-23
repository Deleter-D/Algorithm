package DynamicProgramming;

public class ApproximateMatch {
    public static int ASM(char[] P, char[] T) {
        int i, j;
        int m = P.length, n = T.length;
        int[][] D = new int[m + 1][n + 1];
        for (j = 1; j <= n; j++)
            D[0][j] = j;
        for (i = 0; i <= m; i++)
            D[i][0] = i;
        for (j = 1; j <= n; j++) {
            for (i = 1; i <= m; i++) {
                if (P[i - 1] == T[j - 1])
                    D[i][j] = Math.min(Math.min(D[i - 1][j - 1], D[i - 1][j] + 1), D[i][j - 1] + 1);
                else
                    D[i][j] = Math.min(Math.min(D[i - 1][j - 1] + 1, D[i - 1][j] + 1), D[i][j - 1] + 1);
            }
        }

        return D[m][n];
    }

    public static void main(String[] args) {
        char[] P = "happy".toCharArray();
        char[] T = "hsppay".toCharArray();
        System.out.println(ASM(P, T));
    }
}
