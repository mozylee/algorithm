package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob01405 {
    static int N;
    static double result = 0;
    static double[] probabilities = new double[4];
    static boolean[][] visited;
    static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++)
            probabilities[i] = Integer.parseInt(st.nextToken()) * 0.01;
        visited = new boolean[2 * N + 1][2 * N + 1];
        visited[N][N] = true;
        dfs(N, N, 1.0, 0);
        System.out.println(result);
    }

    static void dfs(int x, int y, double p, int count) {
        if (count == N) {
            result += p;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + DIRECTIONS[i][0];
            int ny = y + DIRECTIONS[i][1];
            if (!visited[nx][ny] && probabilities[i] > 0) {
                visited[nx][ny] = true;
                dfs(nx, ny, p * probabilities[i], count + 1);
                visited[nx][ny] = false;
            }
        }
    }
}