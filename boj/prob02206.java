package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob02206 {
    static int N, M;
    static boolean[][] board;
    static int[][][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        input();
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Trial> queue = new LinkedList<>();
        visited[0][0][1] = 1;
        visited[0][0][0] = 1;
        queue.add(new Trial(0, 0, 1, false));
        while (!queue.isEmpty()) {
            Trial now = queue.poll();
            if (now.x == N - 1 && now.y == M - 1) {
                return now.count;
            }
            int nextCount = now.count + 1;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (!isValid(nx, ny))
                    continue;
                if (board[nx][ny]) {
                    if (visited[nx][ny][now.isBreaked ? 0 : 1] > nextCount) {
                        queue.add(new Trial(nx, ny, nextCount, now.isBreaked));
                        visited[nx][ny][now.isBreaked ? 0 : 1] = nextCount;
                    }
                } else if (!now.isBreaked) {
                    if (visited[nx][ny][0] > nextCount) {
                        queue.add(new Trial(nx, ny, nextCount, true));
                        visited[nx][ny][0] = nextCount;
                    }
                }
            }
        }
        return -1;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new boolean[N][M];
            visited = new int[N][M][2];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = line.charAt(j) != '1';
                    visited[i][j][0] = Integer.MAX_VALUE;
                    visited[i][j][1] = Integer.MAX_VALUE;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR!!!!");
        }
    }

    static class Trial extends Point {
        int count;
        boolean isBreaked;

        Trial(int x, int y, int count, boolean isBreaked) {
            super(x, y);
            this.count = count;
            this.isBreaked = isBreaked;
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}