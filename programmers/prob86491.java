package programmers;

public class prob86491 {
    public static int solution(int[][] sizes) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int[] card : sizes) {
            int x = Math.max(card[0], card[1]);
            int y = Math.min(card[0], card[1]);

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }
        return maxX * maxY;
    }

    public static void main(String[] args) {
        int[][][] testcases = { { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } },
                { { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 } },
                { { 14, 4 }, { 19, 6 }, { 6, 16 }, { 18, 7 }, { 7, 11 } } };

        for (int i = 0; i < testcases.length; i++) {
            System.out.println(solution(testcases[i]));
        }
    }
}
