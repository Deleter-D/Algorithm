package ReduceAndConquerMethod;

public class MedianNumber {
    public static int SearchMid(int[] A, int[] B) {
        int s1 = 0, e1 = A.length - 1, s2 = 0, e2 = B.length - 1;// 两个序列的上下界
        int mid1, mid2;
        while (s1 < e1 && s2 < e2) {
            mid1 = (s1 + e1) / 2;// A的中位数下标
            mid2 = (s2 + e2) / 2;// B的中位数下标
            if (A[mid1] == B[mid2]) return A[mid1];// 第①种情况
            if (A[mid1] < B[mid2]) {// 第②种情况
                if ((s1 + e1) % 2 == 0) s1 = mid1;
                else s1 = mid1 + 1;// 保证两序列长度相等
                e2 = mid2;
            } else {// 第③种情况
                if ((s2 + e2) % 2 == 0) s2 = mid2;
                else s2 = mid2 + 1;
                e1 = mid1;
            }
        }
        if (A[s1] < B[s2]) return A[s1];
        else return B[s2];
    }

    public static void main(String[] args) {
        int[] A = {11, 13, 15, 17, 19};
        int[] B = {2, 4, 10, 15};
        System.out.println(SearchMid(A, B));
    }
}
