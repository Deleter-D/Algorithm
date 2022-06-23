package BruteForceMethod;

import java.util.Arrays;

public class SelectionSort {
    public static void Selection(int[] r) {
        int min, temp;
        for (int i = 0; i < r.length; i++) {
            min = i;
            for (int j = i + 1; j < r.length; j++) {
                if (r[j] < r[min])
                    min = j;
            }
            if (min != i) {
                temp = r[i];
                r[i] = r[min];
                r[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] r = {1, 2, 5, 3, 6, 8, 4, 9};
        Selection(r);
        System.out.println(Arrays.toString(r));
    }
}
