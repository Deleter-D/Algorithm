package GreedyMethod;

public class KnapsackProblem {
    public static double KnapSack(int[] w, int[] v, int C) {
        double[] x = new double[w.length];// 记录物品装入的部分
        int i;
        double maxValue = 0;
        for (i = 0; w[i] < C; i++) {
            x[i] = 1;
            maxValue += v[i];
            C = C - w[i];
        }
        x[i] = (double) C / w[i];
        maxValue += x[i] * v[i];
        return maxValue;
    }

    public static void main(String[] args) {
        int[] w = {2, 2, 4, 6, 5};
        int[] v = {6, 3, 6, 5, 4};
        int C = 10;
        System.out.println(KnapSack(w, v, C));
    }
}
