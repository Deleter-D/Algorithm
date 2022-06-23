package BackTrackMethod;

public class HamiltonianCircuit {
    public static void Hamiton(int[][] arc) {
        int i, k;
        int n = arc.length;
        int[] visited = new int[n];
        int[] x = new int[n];// 存储哈密顿回路经过的顶点
        for (i = 0; i < n; i++) {
            x[i] = 0;
            visited[i] = 0;
        }
        x[0] = 0;
        visited[0] = 1;// 从顶点0出发
        k = 1;
        while (k >= 1) {
            x[k]++;
            while (x[k] < n) {
                if (visited[x[k]] == 0 && arc[x[k - 1]][x[k]] == 1)// 顶点x[k]不在哈密顿回路上,且边(x[k-1],x[k])存在
                    break;// 则跳出内层循环
                else// 否则试探下一个顶点
                    x[k]++;
            }
            if (x[k] < n && k == n - 1 && arc[x[k]][0] == 1) {// 若已经形成哈密顿回路则输出结果
                for (k = 0; k < n; k++)
                    System.out.println(x[k] + 1);
                return;
            } else if (x[k] < n && k < n - 1) {// 若还未形成哈密顿回路则继续算法
                visited[x[k]] = 1;
                k++;
            } else {// 否则取消x[k]顶点的访问标识，回溯
                visited[x[k]] = 0;
                x[k] = 0;
                k--;
                visited[x[k]] = 0;// 此处是为了将回溯后的顶点，即x[k-1]恢复为未访问状态
            }
        }
    }

    public static void main(String[] args) {
        int[][] arc = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0}
        };
        Hamiton(arc);
    }
}
