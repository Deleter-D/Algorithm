package ReduceAndConquerMethod;

import java.util.Arrays;

public class HeapSort {
    public static void SiftHeap(int[] r, int key) {
        int i = key, j = 2 * i + 1, temp;// i为待筛的结点，j为i的左孩子
        while (j < r.length) {// 筛选还没有进行到叶子
            if (j < r.length - 1 && r[j] < r[j + 1]) j++;// 比较i的左右孩子，j为较大者
            if (r[i] > r[j]) break;// 根结点已经大于左右孩子中的较大者
            else {// 根节点与较大者交换
                temp = r[i];
                r[i] = r[j];
                r[j] = temp;
                i = j;
                j = 2 * i + 1;// 被筛的结点位于原来j的位置
            }
        }
    }

    public static void Sort(int[] r) {
        int i, temp;
        for (i = (r.length - 1) / 2; i >= 0; i--) {// 初始建堆
            SiftHeap(r, i);
        }
        for (i = 1; i <= r.length - 1; i++) {// 循环执行移走堆顶元素及重新调整堆的操作
            temp = r[0];
            r[0] = r[r.length - i];
            r[r.length - i] = temp;
            SiftHeap(r, 0);
        }
    }

    public static void main(String[] args) {
        int[] r = {5, 7, 2, 4, 7, 9, 2, 1};
        Sort(r);
        System.out.println(Arrays.toString(r));
    }
}
