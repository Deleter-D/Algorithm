package DivideAndConquerMethod;

import java.util.Arrays;

public class QuickSort {
    public static int Partition(int[] r, int low, int high) {
        int i = low, j = high;
        while (i < j) {
            while (i < j && r[i] <= r[j]) {
                j--;
            }
            if (i < j) {
                int temp = r[i];
                r[i] = r[j];
                r[j] = temp;
            }
            while (i < j && r[i] <= r[j]) {
                i++;
            }
            if (i < j) {
                int temp = r[i];
                r[i] = r[j];
                r[j] = temp;
                j--;
            }
        }
        return i;
    }

    public static void Sort(int[] r, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = Partition(r, low, high);
            Sort(r, low, pivot - 1);
            Sort(r, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] r = {9, 6, 9, 2, 3, 5, 6, 1};
        Sort(r, 0, r.length - 1);
        System.out.println(Arrays.toString(r));
    }
}
