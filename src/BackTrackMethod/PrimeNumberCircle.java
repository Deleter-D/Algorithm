package BackTrackMethod;

public class PrimeNumberCircle {
    public static void PrimeCircle(int n) {
        int i, k;
        int[] circle = new int[n];// 素数环
        for (i = 0; i < n; i++) {// 初始化为0
            circle[i] = 0;
        }
        circle[0] = 1;// 第0个位置填1
        k = 1;
        while (k >= 1) {
            circle[k] = circle[k] + 1;
            while (circle[k] <= n) {
                if (Check(circle, k))// 若位置k可以填写整数circle[k]则跳出内层循环
                    break;
                else// 否则试探下一个数
                    circle[k] = circle[k] + 1;
            }
            if (circle[k] <= n && k == n - 1) {// 若求解完毕则输出解，结束算法
                for (int item : circle) {
                    System.out.println(item);
                }
                return;
            } else if (circle[k] <= n && k < n - 1)// 若未结束则填写下一个位置
                k++;
            else{
                circle[k] = 0;// 回溯
                k--;
            }
        }
    }

    public static boolean Check(int[] circle, int k) {// 判断第k个位置填写是否满足约束条件
        boolean flag;
        for (int i = 0; i < k; i++) {
            if (circle[i] == circle[k])// 判断是否重复
                return false;
        }
        flag = Prime(circle[k] + circle[k - 1]);// 判断相邻数之和是否为素数
        if (flag && k == circle.length - 1) {// 判断第一个和最后一个数之和是否为素数
            flag = Prime(circle[k] + circle[0]);
        }

        return flag;
    }

    public static boolean Prime(int x) {// 判断x是否为素数
        int i, n;
        n = (int) Math.sqrt(x);
        for (i = 2; i <= n; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeCircle(20);
    }
}
