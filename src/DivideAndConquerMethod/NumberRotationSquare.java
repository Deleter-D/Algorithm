package DivideAndConquerMethod;

import java.util.Arrays;

public class NumberRotationSquare {

    public static int[][] Full(int[][] data, int number, int begin, int size) {// 从number开始填写size阶方阵，左上角下标为(begin,begin)
        int i, j, k;
        if (size == 0)// 递归边界，若size为0则无需填写
            return data;
        if (size == 1) {// 递归边界，若size为1
            data[begin][begin] = number;// 则只需填写number
            return data;
        }
        i = begin;
        j = begin;
        for (k = 0; k < size - 1; k++) {
            data[i][j] = number;
            number++;
            i++;// 往下移动
        }
        for (k = 0; k < size - 1; k++) {
            data[i][j] = number;
            number++;
            j++;// 往右移动
        }
        for (k = 0; k < size - 1; k++) {
            data[i][j] = number;
            number++;
            i--;// 往上移动
        }
        for (k = 0; k < size - 1; k++) {
            data[i][j] = number;
            number++;
            j--;// 往左移动
        }
        Full(data, number, begin + 1, size - 2);// 递归填写除最外面一圈的部分

        return data;
    }

    public static void main(String[] args) {
        int[][] data = new int[6][6];
        int[][] result = Full(data, 1, 0, data.length);
        for (int[] item : result) {
            System.out.println(Arrays.toString(item));
        }
    }
}
