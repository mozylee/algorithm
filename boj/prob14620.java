package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob14620 {
    private static StringTokenizer st;
    private static int N, sum = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[][] bought;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        bought = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(sum);
    }

    private static void dfs(int count, int value) {
        if (count == 3) {
            sum = Math.min(sum, value);
            return;
        }
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (check(i, j)) {
                    toggle(i, j);
                    dfs(count + 1, value + getCost(i, j));
                    toggle(i, j);
                }
            }
        }
    }

    private static void toggle(int x, int y) {
        bought[x][y] = !bought[x][y];
        for (int i = 0; i < 4; i++) {
            bought[x + dx[i]][y + dy[i]] = !bought[x + dx[i]][y + dy[i]];
        }
    }

    private static boolean check(int x, int y) {
        int nx, ny;
        if (bought[x][y])
            return false;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (bought[nx][ny])
                return false;
        }
        return true;
    }

    private static int getCost(int x, int y) {
        int cost = map[x][y];
        for (int i = 0; i < 4; i++) {
            cost += map[x + dx[i]][y + dy[i]];
        }
        return cost;
    }
}
