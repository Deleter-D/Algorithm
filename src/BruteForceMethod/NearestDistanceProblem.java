package BruteForceMethod;

public class NearestDistanceProblem {
    public static int ClosestPoints(int[] x, int[] y) {
        int index1 = 0, index2 = 0;
        int temp, minDistace = 1000;
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = i + 1; j < x.length; j++) {
                temp = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
                if (temp < minDistace) {
                    minDistace = temp;
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.println("坐标：(" + x[index1] + "," + y[index1] + "),(" + x[index2] + "," + y[index2] + ")");
        return minDistace;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5};
        int[] y = {1, -2, -5, 4, 6};
        System.out.println("最小距离：" + ClosestPoints(x, y));
    }
}
