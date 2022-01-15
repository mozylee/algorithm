package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class prob21922 {
    private static int N, M;
    private static int count;

    private static int[][] map;
    private static boolean[][][] visited;

    private static Queue<Point> airconditioners = new LinkedList<>();
    private static final int AIR_CONDITIONER = 9;
    private static int[][] DIRECTIONS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        input();
        for (Point a : airconditioners) {
            for (int i = 0; i < 4; i++) {
                go(a.x, a.y, i);
            }
        }
        System.out.println(count);
    }

    private static void go(int x, int y, int d) {
        if (isOOB(x, y) || visited[x][y][d]) {
            return;
        }
        count += isCounted(x, y) ? 1 : 0;
        visited[x][y][d] = true;

        int nd = getNextDirection(x, y, d);
        int nx = x + DIRECTIONS[nd][0];
        int ny = y + DIRECTIONS[nd][1];

        go(nx, ny, nd);
    }

    private static boolean isCounted(int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (visited[x][y][i]) {
                return false;
            }
        }
        return true;
    }

    private static int getNextDirection(int x, int y, int d) {
        // { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        // 상, 우, 하, 좌
        switch (map[x][y]) {
            case 1:
                d += d % 2 == 0 ? 0 : 2;
                break;
            case 2:
                d += d % 2 == 0 ? 2 : 0;
                break;
            case 3:
                d += d % 2 == 0 ? 1 : -1;
                break;
            case 4:
                d += d % 2 == 0 ? -1 : 1;
                break;
        }
        return (d + 4) % 4;
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == AIR_CONDITIONER) {
                    airconditioners.add(new Point(i, j));
                }
            }
        }
    }
}
