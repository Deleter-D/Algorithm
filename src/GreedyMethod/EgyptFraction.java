package GreedyMethod;

import GreedyMethod.utils.CommFactor;

public class EgyptFraction {
    public static void EgyptFrac(int A, int B) {
        int E, R;
        System.out.println(A + "/" + B + "=");
        do {
            E = B / A + 1;// 求A/B包含的最大埃及分数
            System.out.println("1/" + E + "+");
            A = A * E - B;// 本行及下一行求A/B - 1/E
            B = B * E;
            R = CommFactor.getCommFactor(B, A);// 求A，B最大公约数
            if (R > 1) {// 化简A/B
                A = A / R;
                B = B / R;
            }
        } while (A > 1);// 当A/B不是埃及分数时继续循环
        System.out.println("1/" + B);
    }

    public static void main(String[] args) {
        EgyptFrac(7, 8);
    }
}
