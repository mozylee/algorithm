package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class prob02344 {
    private static int N, M;
    private static int[][] board;
    private static ArrayList<Integer> ans = new ArrayList<>();
    private static int[] dx = { 0, -1, 0, 1 };
    private static int[] dy = { 1, 0, -1, 0 };
    private static int[] turn = { 1, 0, 3, 2 };

    public static void main(String[] args) throws IOException {
        input();

        initBoard();

        lightUp();

        answer();
    }

    private static void lightUp() {
        for (int i = 1; i <= N; i++) {
            go(i, 0, 0, true);
        }

        for (int i = 1; i <= M; i++) {
            go(N + 1, i, 1, true);
        }

        for (int i = N; i >= 1; i--) {
            go(i, M + 1, 2, true);
        }

        for (int i = M; i >= 1; i--) {
            go(0, i, 3, true);
        }
    }

    private static void go(int i, int j, int direction, boolean isFirst) {
        if (!isFirst && board[i][j] > 0) {
            ans.add(board[i][j]);
            return;
        }
        i += dx[direction];
        j += dy[direction];

        if (board[i][j] < 0) {
            direction = turn[direction];
        }
        go(i, j, direction, false);
    }

    private static void answer() {
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 2][M + 2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i + 1][j + 1] = -Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void initBoard() {
        int hole = 1;
        for (int i = 1; i <= N; i++) {
            board[i][0] = hole++;
        }

        for (int i = 1; i <= M; i++) {
            board[N + 1][i] = hole++;
        }

        for (int i = N; i >= 1; i--) {
            board[i][M + 1] = hole++;
        }

        for (int i = M; i >= 1; i--) {
            board[0][i] = hole++;
        }
    }
}
