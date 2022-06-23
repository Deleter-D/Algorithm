package DivideAndConquerMethod.utils;

public class PointQuickSort {
    public static int Partition(Point[] r, int low, int high) {
        int i = low, j = high;
        while (i < j) {
            while (i < j && r[i].getY() <= r[j].getY()) {
                j--;
            }
            if (i < j) {
                Point temp = r[i];
                r[i] = r[j];
                r[j] = temp;
            }
            while (i < j && r[i].getY() <= r[j].getY()) {
                i++;
            }
            if (i < j) {
                Point temp = r[i];
                r[i] = r[j];
                r[j] = temp;
                j--;
            }
        }
        return i;
    }

    public static void Sort(Point[] r, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = Partition(r, low, high);
            Sort(r, low, pivot - 1);
            Sort(r, pivot + 1, high);
        }
    }
}
