package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob12100 {
    static final int MAX_COUNT = 5;
    static int N, max = Integer.MIN_VALUE;
    static int[][] board;
    static int[][] origin;
    static int[] selected = new int[MAX_COUNT];

    public static void main(String[] args) throws IOException {
        init();
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int count) {
        if (count == MAX_COUNT) {
            copyBoard();
            for (int i = 0; i < MAX_COUNT; i++) {
                move(selected[i]);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }
        for (int i = 0; i < MAX_COUNT; i++) {
            selected[count] = i;
            dfs(count + 1);
        }
    }

    public static void move(int instructor) {
        switch (instructor) {
            case 0:
                up();
                break;
            case 1:
                down();
                break;
            case 2:
                left();
                break;
            case 3:
                right();
                break;
        }
    }

    private static void up() {
        int count;
        for (int i = 0; i < N; i++) {
            count = 0;
            // 방향대로 이동
            for (int j = 0; j < N; j++) {
                if (board[j][i] == 0)
                    continue;
                int end = j;
                while (++end < N) {
                    if (board[end][i] == 0)
                        continue;
                    if (board[end][i] != board[j][i])
                        break;
                    board[j][i] *= 2;
                    board[end][i] = 0;
                    break;
                }
                board[count++][i] = board[j][i];
                if (count - 1 != j)
                    board[j][i] = 0;
            }
        }
    }

    private static void down() {
        int count;
        for (int i = 0; i < N; i++) {
            count = N - 1;
            // 방향대로 이동
            for (int j = N - 1; j >= 0; j--) {
                if (board[j][i] == 0)
                    continue;
                int end = j;
                while (--end >= 0) {
                    if (board[end][i] == 0)
                        continue;
                    if (board[end][i] != board[j][i])
                        break;
                    board[j][i] *= 2;
                    board[end][i] = 0;
                    break;
                }
                board[count--][i] = board[j][i];
                if (count + 1 != j)
                    board[j][i] = 0;
            }
        }
    }

    private static void left() {
        int count;
        for (int i = 0; i < N; i++) {
            count = 0;
            // 방향대로 이동
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0)
                    continue;
                int end = j;
                while (++end < N) {
                    if (board[i][end] == 0)
                        continue;
                    if (board[i][end] != board[i][j])
                        break;
                    board[i][j] *= 2;
                    board[i][end] = 0;
                    break;

                }
                board[i][count++] = board[i][j];
                if (count - 1 != j)
                    board[i][j] = 0;
            }
        }
    }

    private static void right() {
        int count;
        for (int i = 0; i < N; i++) {
            count = N - 1;
            // 방향대로 이동
            for (int j = N - 1; j >= 0; j--) {
                if (board[i][j] == 0)
                    continue;
                int end = j;
                while (--end >= 0) {
                    if (board[i][end] == 0)
                        continue;
                    if (board[i][end] != board[i][j])
                        break;
                    board[i][j] *= 2;
                    board[i][end] = 0;
                    break;
                }
                board[i][count--] = board[i][j];
                if (count + 1 != j)
                    board[i][j] = 0;
            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        origin = new int[N][N];
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int block = Integer.parseInt(st.nextToken());
                origin[i][j] = block;
                max = Math.max(max, block);
            }
        }
    }

    public static void copyBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = origin[i][j];
            }
        }
    }
}
