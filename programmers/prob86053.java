package programmers;

public class prob86053 {
    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0, right = (long) 1e18;

        long min = Long.MAX_VALUE;
        while (left <= right) {
            long time = (left + right) / 2;
            if (canCarryAll(a, b, g, s, w, t, time)) {
                min = Math.min(min, time);
                right = time - 1;
                continue;
            }
            left = time + 1;
        }
        return min;
    }

    private static boolean canCarryAll(int a, int b, int[] g, int[] s, int[] w, int[] t, long time) {
        long gold = 0;
        long silver = 0;
        long metal = 0;
        for (int i = 0; i < t.length; i++) {
            long moveCount = getMoveCount(t[i], w[i], time);
            gold += Math.min(g[i], moveCount);
            silver += Math.min(s[i], moveCount);
            metal += Math.min(g[i] + s[i], moveCount);
        }

        return gold >= a && silver >= b && metal >= a + b;
    }

    private static long getMoveCount(long oneWayTime, long weight, long time) {
        return weight * (long) Math.ceil((double) (time / oneWayTime) / 2);
    }

    public static void main(String[] args) {
        // 50
        System.out.println(solution(10, 10, new int[] { 100 }, new int[] { 100 }, new int[] { 7 }, new int[] { 10 }));
        // 499
        System.out.println(solution(90, 500, new int[] { 70, 70, 0 }, new int[] { 0, 0, 500 },
                new int[] { 100, 100, 2 }, new int[] { 4, 8, 1 }));
    }
}
