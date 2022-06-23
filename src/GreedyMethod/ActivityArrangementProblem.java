package GreedyMethod;

import java.util.Arrays;

public class ActivityArrangementProblem {
    public static int ActiveManage(int[] s, int[] f) {
        int i, j, count;
        int n = s.length;
        int[] B = new int[n];
        B[0] = 1;// 安排活动1
        j = 0;
        count = 1;
        for (i = 1; i < n; i++) {// 依次考察每个活动
            if (s[i] >= f[j]) {// 活动i与集合B中最后结束的活动j相容
                B[i] = 1;// 安排活动i
                j = i;// j是目前可以安排的最后一个活动
                count++;
            } else {
                B[i] = 0;
            }
        }

        System.out.println(Arrays.toString(B));
        return count;// 返回已经安排的活动数
    }

    public static void main(String[] args) {
        int[] s = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] f = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println(ActiveManage(s, f));
    }
}
