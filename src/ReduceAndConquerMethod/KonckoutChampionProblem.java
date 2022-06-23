package ReduceAndConquerMethod;

public class KonckoutChampionProblem {
    public static char Game(char[] r) {
        int i = r.length;
        System.out.println(r);
        while (i > 1) {
            i = i / 2;
            for (int j = 0; j < i; j++)
                if (Comp(r[j + i], r[j]))// 分组比赛
                    r[j] = r[j + i]; // 胜者填入r[j]
            for (int k = 0; k < i; k++) {
                System.out.print(r[k]);
            }
            System.out.println();
        }

        return r[0];
    }

    public static boolean Comp(char i, char j) {// 模拟比赛，若i胜则返回true
        return i > j;
    }

    public static void main(String[] args) {
        char[] r = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        System.out.println(Game(r));
    }
}
