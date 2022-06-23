package DivideAndConquerMethod;

public class SumOfLargestSubSegmentProblem {
    public static int MaxSum(int[] a, int left, int right) {
        int sum = 0, midSum = 0, leftSum = 0, rightSum = 0;
        int center, s1, s2, lefts, rights;
        if (left == right)// 若序列长度为1，则直接求解
            sum = a[left];
        else {
            center = (left + right) / 2;// 从中间划分
            leftSum = MaxSum(a, left, center);// 情况①，最大和在左半部分，递归求解
            rightSum = MaxSum(a, center + 1, right);// 情况②，最大和在右半部分，递归求解
            s1 = 0;
            lefts = 0;// 以下为情况③，组成最大和的元素跨越中轴线
            for (int i = center; i >= left; i--) {// 先求解s1
                lefts += a[i];// 指针向左运动并累加
                if (lefts > s1)// 遇到负数会导致lefts变小，故不会赋值给s1
                    s1 = lefts;
            }
            s2 = 0;
            rights = 0;
            for (int j = center + 1; j <= right; j++) {// 再求解s2
                rights += a[j];// 指针向右运动并累加
                if (rights > s2)// 遇到负数会导致rights变小，故不会赋值给s2
                    s2 = rights;
            }
            midSum = s1 + s2;// 计算情况③的最大子段和
            sum = Math.max(Math.max(midSum, leftSum), rightSum);// 三者取最大
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(MaxSum(a, 0, a.length - 1));
    }

}
