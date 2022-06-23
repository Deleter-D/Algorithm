package BackTrackMethod;

public class BatchJobSchedulingProblem {
    public static int BatchJob(int[] a, int[] b) {// a记录n个作业在机器1上所需时间，b记录n个作业在机器2上所需时间
        int i, k;
        int n = a.length;
        int[] x = new int[n + 1];// 存储具体的作业调度，x[k]表示第k个作业的编号
        int[] sum1 = new int[n + 1];// 存储机器1的完成时间
        int[] sum2 = new int[n + 1];// 存储机器2的完成时间
        int bestTime = 10000;// 假设时间不超过10000

        for (i = 1; i <= n; i++) {
            x[i] = -1;
            sum1[i] = 0;
            sum2[i] = 0;
        }
        sum1[0] = 0;
        sum2[0] = 0;
        k = 1;
        while (k >= 1) {
            x[k]++;// 安排第k个作业，作业编号为x[k]
            while (x[k] < n) {
                for (i = 1; i < k; i++) {// 检测作业x[k]是否重复处理
                    if (x[i] == x[k]) {
                        break;
                    }
                }
                if (i == k) {// 作业x[k]还未处理
                    sum1[k] = sum1[k - 1] + a[x[k]];
                    sum2[k] = Math.max(sum1[k], sum2[k - 1]) + b[x[k]];
                    if (sum2[k] <= bestTime)// 未超过目前最短时间则跳出内层循环
                        break;
                    else// 否则剪枝
                        x[k]++;
                } else // 作业x[k]已经处理，则处理下一个作业
                    x[k]++;
            }
            if (x[k] < n && k < n) {
                k++;// 安排下一个作业
            } else {
                if (x[k] < n && k == n) {
                    if (bestTime >= sum2[k]) {
                        bestTime = sum2[k];
                        System.out.print("目前最短作业安排是：");
                        for (int j = 1; j <= n; j++)
                            System.out.print(x[j] + 1);
                        System.out.print("，");
                        System.out.print("最短时间是：" + bestTime);
                        System.out.println();
                    }
                } else
                    x[k--] = -1;// 重置x[k]，回溯
            }
        }
        return bestTime;
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 4};
        int[] b = {3, 2, 1};
        BatchJob(a, b);
    }
}
