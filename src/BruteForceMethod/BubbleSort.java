package BruteForceMethod;

import java.util.Arrays;

public class BubbleSort {
    public static void Bubble(int[] r) {
        int temp;
        boolean flag;
        for (int i = 0; i < r.length - 1; i++) {
            flag = false;
            for (int j = r.length - 1; j > i; j--) {
                if (r[j] < r[j - 1]) {
                    temp = r[j];
                    r[j] = r[j - 1];
                    r[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    public static void main(String[] args) {
        int[] r = {1, 2, 5, 3, 6, 8, 4, 9};
        Bubble(r);
        System.out.println(Arrays.toString(r));
    }
}
