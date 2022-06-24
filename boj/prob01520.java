package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob01520 {
    private static int N, M;

    private static int[][] board;
    private static boolean[][] visited;
    private static int[][] counts;

    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        if (counts[x][y] >= 0) {
            return counts[x][y];
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isOOB(nx, ny) || visited[nx][ny] || board[x][y] <= board[nx][ny]) {
                continue;
            }
            visited[nx][ny] = true;
            sum += counts[nx][ny] >= 0 ? counts[nx][ny] : dfs(nx, ny);
            visited[nx][ny] = false;
        }
        counts[x][y] = sum;
        return sum;
    }

    private static boolean isOOB(int x, int y) {
        return isBounded(x, N) || isBounded(y, M);
    }

    private static boolean isBounded(int x, int upper) {
        return x < 0 || x >= upper;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        counts = new int[N][M];
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                counts[i][j] = -1;
            }
        }

        counts[N - 1][M - 1] = 1;
        visited = new boolean[N][M];
    }
}
