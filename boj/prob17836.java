package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob17836 {
    static int N, M, T;
    static Point gramr;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static boolean[][] map;

    public static void main(String[] args) {
        input();
        int min = bfs(gramr.x, gramr.y) + (N - gramr.x + M - gramr.y - 2);
        min = Math.min(min, bfs(N - 1, M - 1));
        System.out.println(min <= T ? min : "Fail");
    }

    static int bfs(int x, int y) {
        Queue<Trial> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new Trial(0, 0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Trial now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx == x && ny == y) {
                    return now.time + 1;
                }
                if (!isValid(nx, ny) || visited[nx][ny] || !map[nx][ny])
                    continue;
                visited[nx][ny] = true;
                queue.add(new Trial(nx, ny, now.time + 1));
            }
        }
        return 100000;
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
            T = Integer.parseInt(st.nextToken());
            map = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value == 2) {
                        gramr = new Point(i, j);
                        map[i][j] = true;
                        continue;
                    }
                    map[i][j] = value <= 0;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR!!!!");
        }
    }

    static class Trial extends Point {
        int time;

        Trial(int x, int y, int time) {
            super(x, y);
            this.time = time;
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
