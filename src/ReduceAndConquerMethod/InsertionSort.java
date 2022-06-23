package ReduceAndConquerMethod;

import java.util.Arrays;

public class InsertionSort {
    public static void InsertSort(int[] r) {
        int j;
        for (int i = 2; i <= r.length - 1; i++) {
            r[0] = r[i];
            for (j = i - 1; r[0] < r[j]; j--)
                r[j + 1] = r[j];
            r[j + 1] = r[0];
        }
    }

    public static void main(String[] args) {
        int[] r = {0, 5, 7, 2, 4, 7, 9, 2, 1};
        InsertSort(r);
        System.out.println(Arrays.toString(r));
    }
}
