package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob01600 {
    private static int K, W, H;
    private static boolean[][] board;
    private static boolean[][][] visited;

    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    private static int[] kx = { 1, 2, 2, 1, -1, -2, -2, -1 };
    private static int[] ky = { 2, 1, -1, -2, -2, -1, 1, 2 };

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial(0, 0, K, 0));
        visited[0][0][K] = true;

        while (!queue.isEmpty()) {
            Trial now = queue.poll();
            if (now.x == H - 1 && now.y == W - 1) {
                return now.time;
            }
            if (now.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = now.x + kx[i];
                    int ny = now.y + ky[i];

                    if (isOOB(nx, ny) || visited[nx][ny][now.k - 1] || !board[nx][ny]) {
                        continue;
                    }
                    if (nx == H - 1 && ny == W - 1) {
                        return now.time + 1;
                    }
                    visited[nx][ny][now.k - 1] = true;
                    queue.add(new Trial(nx, ny, now.k - 1, now.time + 1));
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isOOB(nx, ny) || visited[nx][ny][now.k] || !board[nx][ny]) {
                    continue;
                }
                if (nx == H - 1 && ny == W - 1) {
                    return now.time + 1;
                }
                visited[nx][ny][now.k] = true;
                queue.add(new Trial(nx, ny, now.k, now.time + 1));
            }
        }
        return -1;
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= H || y < 0 || y >= W;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        visited = new boolean[H][W][K + 1];

        board = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) == 0;
            }
        }
        br.close();
    }

    private static class Trial {
        int x, y, k, time;

        Trial(int x, int y, int k, int time) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.time = time;
        }
    }
}
