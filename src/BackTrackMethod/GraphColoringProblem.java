package BackTrackMethod;

public class GraphColoringProblem {
    public static void GraphColor(int[][] arc, int m) {// m种颜色
        int i, k = 0;
        int n = arc.length;
        int[] color = new int[n];
        for (i = 0; i < n; i++) {// 初始化
            color[i] = 0;
        }
        while (k >= 0) {
            color[k]++;// 取下一种颜色
            while (color[k] <= m) {
                if (Ok(arc, color, k))// 若顶点k可以填入颜色color[k]则跳出内层循环
                    break;
                else// 否则试探下一种颜色
                    color[k]++;
            }
            if (color[k] <= m && k == n - 1) {// 若求解完毕，输出解
                for (int item : color) {
                    System.out.println(item);
                }
                return;
            } else if (color[k] <= m && k < n - 1)// 若未结束，则填充下一个顶点
                k++;
            else// 若每个颜色都不能填入，则回溯
                color[k--] = 0;
        }
    }

    public static boolean Ok(int[][] arc, int[] color, int k) {// 判断顶点k的着色是否发生冲突
        for (int i = 0; i < k; i++)
            if (arc[k][i] == 1 && color[i] == color[k])
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] arc = {
                {0, 1, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };
        GraphColor(arc, 3);
    }
}
