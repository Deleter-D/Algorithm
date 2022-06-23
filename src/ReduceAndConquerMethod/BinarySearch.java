package ReduceAndConquerMethod;

public class BinarySearch {
    public static int BinSearch(int[] r, int key) {
        int low = 0, high = r.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key < r[mid]) high = mid - 1;
            else if (key > r[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] r = {1, 3, 4, 6, 8, 9, 13};
        System.out.println(BinSearch(r, 13));
    }
}
