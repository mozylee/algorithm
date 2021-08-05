package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class prob01303 {
    static int N, M;
    static int B, W;
    static boolean[][] map;
    static boolean[][] visited;
    static int[][] DIRECTION = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) {
        input();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (!visited[i][j])
                    bfs(i, j);
        System.out.println(W + " " + B);
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        int result = 1;
        boolean isB = map[x][y];
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + DIRECTION[i][0];
                int ny = now.y + DIRECTION[i][1];
                if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == isB) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    result++;
                }
            }
        }
        if (isB)
            B += result * result;
        else
            W += result * result;

    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new boolean[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++)
                    map[i][j] = line.charAt(j) == 'B';
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR!");
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
