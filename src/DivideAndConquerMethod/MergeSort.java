package DivideAndConquerMethod;

import java.util.Arrays;

public class MergeSort {
    public static void Merge(int[] r, int[] res, int start, int mid, int end) {
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (r[i] <= r[j]) {
                res[k++] = r[i++];
            } else {
                res[k++] = r[j++];
            }
        }
        while (i <= mid) {
            res[k++] = r[i++];
        }
        while (j <= end) {
            res[k++] = r[j++];
        }
    }

    public static void Sort(int[] r, int start, int end) {
        int mid;
        int[] temp = new int[r.length];
        if (start == end) return;
        else {
            mid = (start + end) / 2;
            Sort(r, start, mid);
            Sort(r, mid + 1, end);
            Merge(r, temp, start, mid, end);
            for (int i = start; i <= end; i++) {
                r[i] = temp[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] r = {9, 6, 9, 2, 3, 5, 6, 1};
        Sort(r, 0, r.length - 1);
        System.out.println(Arrays.toString(r));
    }
}
