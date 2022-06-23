package DivideAndConquerMethod;

import DivideAndConquerMethod.utils.Point;
import DivideAndConquerMethod.utils.PointQuickSort;


public class NearestDistanceProblem {
    public static double Closest(Point[] S, int low, int high) {
        double d1, d2, d3, d;
        int mid, i, j, index;
        Point[] P = new Point[S.length]; //存放点集P1和P2
        if (high - low == 1) //只有两个点
            return Distance(S[low], S[high]);
        if (high - low == 2) { //只有三个点
            d1 = Distance(S[low], S[low + 1]);
            d2 = Distance(S[low + 1], S[high]);
            d3 = Distance(S[low], S[high]);
            if ((d1 < d2) && (d1 < d3))
                return d1;
            else if (d2 < d3)
                return d2;
            else
                return d3;
        }

        mid = (low + high) / 2; //计算中间点
        d1 = Closest(S, low, mid); //递归求解子问题①
        d2 = Closest(S, mid + 1, high); //递归求解子问题②
        d = Math.min(d1, d2); //一下求解子问题③
        index = 0;
        for (i = mid; (i >= low) && (S[mid].getX() - S[i].getX() < d); i--) { //建立点集P1
            P[index++] = S[i];
        }
        for (i = mid + 1; (i <= high) && (S[i].getX() - S[mid].getX() < d); i++) { //建立点集P2
            P[index++] = S[i];
        }
        PointQuickSort.Sort(P, 0, index - 1);//将集合P1和P2按y坐标升序排列
        for (i = 0; i < index; i++) {
            for (j = i + 1; j < index; j++) {
                if (P[j].getY() - P[i].getY() >= d)
                    break;
                else {
                    d3 = Distance(P[i], P[j]);
                    if (d3 < d) d = d3;
                }
            }
        }
        return d;
    }

    public static double Distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, -2);
        Point p3 = new Point(3, -5);
        Point p4 = new Point(4, 4);
        Point p5 = new Point(5, 6);
        Point[] P = {p1, p2, p3, p4, p5};
        System.out.println(Closest(P, 0, 4));
    }
}
