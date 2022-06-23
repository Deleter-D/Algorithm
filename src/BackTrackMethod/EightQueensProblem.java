package BackTrackMethod;

public class EightQueensProblem {
    public static void Queen(int n) {
        int k = 0;
        int[] x = new int[n];// x[i]表示第i个皇后放在第i行的第x[i]列
        for (int i = 0; i < n; i++)// 初始化为-1
            x[i] = -1;
        while (k >= 0) {// 摆放皇后k
            x[k]++;// 在下一列摆放皇后k
            while (x[k] < n && Place(x, k)) {// 发生冲突
                x[k]++;
            }
            if (x[k] < n && k == n - 1) {// 求解完成，输出
                for (int i = 0; i < n; i++) {
                    System.out.println(x[i] + 1);
                }
                return;
            } else if (x[k] < n && k < n - 1) {// 求解未完成，摆放下一个皇后
                k++;
            } else {// 重置x[k]，回溯
                x[k--] = -1;
            }
        }
        System.out.println("无解");
    }

    public static boolean Place(int[] x, int k) {// 判断放置是否冲突
        for (int i = 0; i < k; i++) {
            if (x[i] == x[k] || Math.abs(i - k) == Math.abs(x[i] - x[k])) {// 若在同一列或同一斜线
                return true;// 返回冲突
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Queen(4);
    }
}
