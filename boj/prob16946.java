package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob16946 {
    static int N, M;
    static int[][] map;
    static int[][] origin;
    static Queue<Point> walls = new LinkedList<>();
    static ArrayList<Integer> areas = new ArrayList<>();
    static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) {
        input();
        int area = 1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 0) {
                    areas.add(0);
                    bfs(i, j, area++);
                }
        breakWall();
        print(origin);
    }

    static void breakWall() {
        while (!walls.isEmpty()) {
            Point now = walls.poll();
            HashSet<Integer> selected = new HashSet<>();
            for (int i = 0; i < DIRECTIONS.length; i++) {
                int nx = now.x + DIRECTIONS[i][0];
                int ny = now.y + DIRECTIONS[i][1];
                if (isValid(nx, ny) && map[nx][ny] > 0)
                    selected.add(map[nx][ny]);
            }
            for (Integer i : selected)
                origin[now.x][now.y] += areas.get(i);
        }
    }

    static void bfs(int x, int y, int area) {
        int count = 1;
        Queue<Point> q = new LinkedList<>();
        map[x][y] = area;
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < DIRECTIONS.length; i++) {
                int nx = now.x + DIRECTIONS[i][0];
                int ny = now.y + DIRECTIONS[i][1];
                if (isValid(nx, ny) && map[nx][ny] == 0) {
                    map[nx][ny] = area;
                    q.add(new Point(nx, ny));
                    count++;
                }
            }
        }
        areas.set(area, count);
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
            map = new int[N][M];
            origin = new int[N][M];
            areas.add(0);
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    int value = line.charAt(j) - '0';
                    if (value == 1)
                        walls.offer(new Point(i, j));
                    map[i][j] = -value;
                    origin[i][j] = value;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    static void print(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                sb.append(arr[i][j] % 10);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
