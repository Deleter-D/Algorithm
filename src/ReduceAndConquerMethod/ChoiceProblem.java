package ReduceAndConquerMethod;

public class ChoiceProblem {
    public static int Partition(int[] r, int low, int high) {// 划分
        int i = low, j = high;
        while (i < j) {
            while (i < j && r[i] <= r[j]) j--;// 右侧扫描
            if (i < j) {// 将较小的元素交换到前面
                int temp = r[i];
                r[i] = r[j];
                r[j] = temp;
                i++;
            }
            while (i < j && r[i] <= r[j]) i++;// 左侧扫描
            if (i < j) {// 将较大元的元素交换到后面
                int temp = r[i];
                r[i] = r[j];
                r[j] = temp;
                j--;
            }
        }
        return i;// 返回枢轴位置
    }

    public static int SelectMinK(int[] r, int low, int high, int k) {// 在r[low]和r[high]之间寻找第k小的元素
        int pivot = Partition(r, low, high);// 划分得到枢轴位置
        if (pivot == k)// 查找成功
            return r[pivot];
        if (pivot > k)// 枢轴大于k，则说明第k小元素在枢轴左侧
            return SelectMinK(r, low, pivot - 1, k);
        else// 否则在右侧寻找
            return SelectMinK(r, pivot + 1, high, k);
    }

    public static void main(String[] args) {
        int[] r = {5, 9, 12, 3, 8, 17, 4, 22};
        System.out.println(SelectMinK(r, 0, r.length - 1, 1));
    }
}
