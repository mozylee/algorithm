package programmers;

public class prob17687 {
    private static final int ALPHABET = 55;

    public static String solution(int n, int t, int m, int p) {
        StringBuilder everyCases = getEveryDigit(n, t, m);
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < t; i++) {
            ret.append(everyCases.charAt(i * m + p - 1));
        }
        return ret.toString();
    }

    private static StringBuilder getEveryDigit(int n, int t, int m) {
        StringBuilder ret = new StringBuilder("0");
        final int MAX = t * m;
        int i = 0;
        while (ret.length() <= MAX + 1) {
            ret.append(getDigit(i++, n));
        }
        return ret;
    }

    private static StringBuilder getDigit(int i, int n) {
        StringBuilder ret = new StringBuilder();
        while (i > 0) {
            int v = i % n;
            ret.append(v > 9 ? ((char) (v + ALPHABET)) + "" : v);
            i /= n;
        }
        return ret.reverse();
    }

    public static void main(String[] args) {
        int[] n = { 2, 16, 16 };
        int[] t = { 4, 16, 16 };
        int[] m = { 2, 2, 2 };
        int[] p = { 1, 1, 2 };
        for (int i = 0; i < p.length; i++) {
            System.out.println(solution(n[i], t[i], m[i], p[i]));
        }
        // System.out.println(getDigit(10, 11));
    }
}

// "0111"
// "02468ACE11111111"
// "13579BDF01234567"