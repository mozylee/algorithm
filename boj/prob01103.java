package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob01103 {
    private static int N, M;

    private static int[][] board;
    private static boolean[][] visited;
    private static int[][] dp;

    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        if (visited[x][y]) {
            return -1;
        }
        visited[x][y] = true;

        int max = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + board[x][y] * dx[i];
            int ny = y + board[x][y] * dy[i];

            if (isOOB(nx, ny) || board[nx][ny] == -1) {
                continue;
            }
            if (dp[nx][ny] == -1) {
                int flag = dfs(nx, ny);
                if (flag == -1) {
                    return -1;
                }
                dp[nx][ny] = Math.max(dp[nx][ny], flag);
            }
            max = Math.max(max, dp[nx][ny]);
        }

        visited[x][y] = false;
        return 1 + max;
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];

        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) != 'H' ? line.charAt(j) - '0' : -1;
            }
        }
    }
}
