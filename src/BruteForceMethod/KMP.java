package BruteForceMethod;

public class KMP {
    public static void GetNext(String target, int[] next) {
        int i, j, len;
        next[0] = -1;
        for (j = 1; j < target.length() - 1; j++) {
            for (len = j - 1; len >= 1; len--) {
                for (i = 0; i < len; i++) {
                    if (target.charAt(i) != (target.charAt(j - len + i))) {
                        break;
                    }
                }
                if (i == len) {
                    next[j] = len;
                    break;
                }
            }
        }
    }

    public static int KMPAlgorithm(String str, String target) {
        int i = 0, j = 0;
        int[] next = new int[target.length()];
        GetNext(target, next);
        while (i < str.length() && j < target.length()) {
            if (str.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
        if (j == target.length()) {
            return (i - target.length() + 1);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        //String str = "aaacaaacaaabaa";
        //String target = "aabaa";
        String str = "googlagooglegoogla";
        String target = "google";
        System.out.println(KMPAlgorithm(str, target));
    }
}
