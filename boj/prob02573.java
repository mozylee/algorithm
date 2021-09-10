package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob02573 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Iceberg> queue = new LinkedList<>();
    static final int[][] DIRECTIONS = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    static final int DIRECTIONS_LENGTH = 4;

    public static void main(String[] args) {
        input();
        System.out.println(bfs());
    }

    static int bfs() {
        int year = 0;
        while (!queue.isEmpty()) {
            if (getAreaAmount() > 1) {
                return year;
            }
            int[] losses = new int[queue.size()];
            for (int i = 0; i < losses.length; i++) {
                int loss = 0;
                Iceberg now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + DIRECTIONS[j][0];
                    int ny = now.y + DIRECTIONS[j][1];
                    if (!isVaild(nx, ny) || map[nx][ny] > 0)
                        continue;
                    loss++;
                }
                losses[i] = loss;
                queue.add(now);
            }
            for (int i = 0; i < losses.length; i++) {
                Iceberg now = queue.poll();
                int height = now.height - losses[i];
                map[now.x][now.y] = height > 0 ? height : 0;
                if (height > 0) {
                    queue.add(new Iceberg(now.x, now.y, height));
                }
            }
            year++;
        }
        return 0;
    }

    static void dfs(int x, int y) {
        if (visited[x][y])
            return;
        visited[x][y] = true;
        for (int i = 0; i < DIRECTIONS.length; i++) {
            int nx = x + DIRECTIONS[i][0];
            int ny = y + DIRECTIONS[i][1];
            if (!isVaild(nx, ny) || visited[nx][ny] || map[nx][ny] == 0)
                continue;
            dfs(nx, ny);
        }
    }

    static int getAreaAmount() {
        int amount = 0;
        visited = new boolean[N][M];
        for (Iceberg iceberg : queue) {
            if (!visited[iceberg.x][iceberg.y]) {
                dfs(iceberg.x, iceberg.y);
                amount++;
            }
        }
        return amount;
    }

    static boolean isVaild(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > 0) {
                        queue.add(new Iceberg(i, j, map[i][j]));
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("ERROR!!!");
        }
    }

    static class Iceberg {
        int x, y, height;

        Iceberg(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}