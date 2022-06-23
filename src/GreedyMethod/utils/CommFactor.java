package GreedyMethod.utils;

public class CommFactor {
    public static int getCommFactor(int m, int n) {
        int r = m % n;
        while (r != 0) {
            m = n;
            n = r;
            r = m % n;
        }
        return n;
    }
}
