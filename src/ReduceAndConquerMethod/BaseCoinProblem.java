package ReduceAndConquerMethod;

public class BaseCoinProblem {
    private static final int[] a = {2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2};
    private static final int n = a.length;

    public static int Coin(int low, int high, int n) {
        int i, num1, num2, num3;// num1、2、3存储3组硬币的数量
        int add1 = 0, add2 = 0;// add1、2存储前两组硬币的重量
        if (n == 1) return low + 1;// 递归结束条件
        if (n % 3 == 0) num1 = num2 = n / 3;// 返回的是序号，下标加1
        else num1 = num2 = n / 3 + 1; // 前两组有n/3(向上取整)枚硬币
        num3 = n - num1 - num2;
        for (i = 0; i < num1; i++)
            add1 += a[low + i];
        for (i = num1; i < num1 + num2; i++)
            add2 += a[low + i];
        if (add1 < add2)// 在第一组查找，下标范围low ~ low+num1-1
            return Coin(low, low + num1 - 1, num1);
        else if (add1 > add2)// 在第二组查找，下标范围low+num1 ~ low+num1+num2-1
            return Coin(low + num1, low + num1 + num2 - 1, num2);
        else// 在第三组查找，下标范围low+num1+num2 ~ high
            return Coin(low + num1 + num2, high, num3);
    }

    public static void main(String[] args) {
        System.out.println(Coin(0, 7, n));
    }
}
