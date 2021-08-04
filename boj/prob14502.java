package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob14502 {
    static int N, M, max = Integer.MIN_VALUE;
    static int originSafe;
    static final int MAX_COUNT = 3, DIRECTION_COUNT = 4;
    static int[][] origin, map;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, -1, 1 };
    static Queue<Point> originQueue = new LinkedList<>();

    public static void main(String[] args) {
        input();
        backtrack(0, 0, 0);
        System.out.println(max);
    }

    public static int bfs() {
        initMap();
        int count = originSafe - MAX_COUNT;
        Queue<Point> queue = new LinkedList<>();
        queue.addAll(originQueue);

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < DIRECTION_COUNT; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isValid(nx, ny) && map[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    map[nx][ny] = 2;
                    count--;
                }
            }
        }
        return count;
    }

    public static void backtrack(int x, int y, int count) {
        if (count == MAX_COUNT) {
            max = Math.max(max, bfs());
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (origin[i][j] == 0) {
                    origin[i][j] = 1;
                    backtrack(i, j, count + 1);
                    origin[i][j] = 0;
                }
            }
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            origin = new int[N][M];
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    origin[i][j] = Integer.parseInt(st.nextToken());
                    if (origin[i][j] == 0)
                        originSafe++;
                    else if (origin[i][j] == 2)
                        originQueue.add(new Point(i, j));
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    static void initMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = origin[i][j];
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
