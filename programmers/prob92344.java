package programmers;

public class prob92344 {
    static int R, C;

    public static int solution(int[][] board, int[][] skill) {
        R = board.length;
        C = board[0].length;
        int[][] change = new int[R][C];
        for (int[] s : skill) {
            turn(change, s[0], s[1], s[2], s[3], s[4], s[5]);
        }
        return sum(board, change);
    }

    private static void turn(int[][] b, int type, int r1, int c1, int r2, int c2, int degree) {
        degree *= type == 1 ? -1 : 1;
        b[r1][c1] += degree;
        boolean d = r2 + 1 < R;
        if (d)
            b[r2 + 1][c1] -= degree;
        boolean d2 = c2 + 1 < C;
        if (d2)
            b[r1][c2 + 1] -= degree;
        if (d && d2)
            b[r2 + 1][c2 + 1] += degree;
    }

    private static int sum(int[][] board, int[][] change) {
        accmulate(change);
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += board[i][j] + change[i][j] > 0 ? 1 : 0;
            }
        }
        return sum;
    }

    private static void accmulate(int[][] change) {
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                change[i][j] += change[i - 1][j];
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 1; j < C; j++) {
                change[i][j] += change[i][j - 1];
            }
        }
    }

    public static void main(String[] args) {
        int[][][] board = { { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } },
                { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } } };
        int[][][] skill = { { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } },
                { { 1, 1, 1, 2, 2, 4 }, { 1, 0, 0, 1, 1, 2 }, { 2, 2, 0, 2, 0, 100 } } };
        // 10
        // 6
        for (int i = 0; i < skill.length; i++) {
            System.out.println(solution(board[i], skill[i]));
        }
    }
}
