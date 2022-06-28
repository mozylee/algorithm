package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob21610 {
    private static int N, M;
    private static int MAX;

    private static int[][] map;
    private static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
    private static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

    private static Instruction[] instructions;

    public static void main(String[] args) throws IOException {
        input();

        rainDance();

        System.out.println(getSum());
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    private static void rainDance() {
        Queue<Point> clouds = initClouds();
        HashSet<Point> hs = new HashSet<>();

        for (Instruction inst : instructions) {
            // 1, 2
            for (Point cloud : clouds) {
                cloud.x = (cloud.x + dx[inst.d] * inst.s + MAX) % N;
                cloud.y = (cloud.y + dy[inst.d] * inst.s + MAX) % N;
                map[cloud.x][cloud.y] += 1;
                hs.add(cloud);
            }

            // 3, 4
            while (!clouds.isEmpty()) {
                Point cloud = clouds.poll();

                int count = 0;
                for (int i = 1; i < 8; i += 2) {
                    int nx = cloud.x + dx[i];
                    int ny = cloud.y + dy[i];

                    count += !isOOB(nx, ny) && map[nx][ny] > 0 ? 1 : 0;
                }

                map[cloud.x][cloud.y] += count;
            }

            // 5
            getNextClouds(clouds, hs);
            hs.clear();
        }
    }

    private static void getNextClouds(Queue<Point> clouds, HashSet<Point> hs) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] < 2) {
                    continue;
                }

                Point next = new Point(i, j);
                if (hs.contains(next)) {
                    continue;
                }

                map[i][j] -= 2;
                clouds.add(next);
            }
        }
    }

    private static boolean isOOB(int nx, int ny) {
        return nx < 0 || nx >= N || ny < 0 || ny >= N;
    }

    private static Queue<Point> initClouds() {
        Queue<Point> clouds = new LinkedList<>();
        for (int i = N - 2; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                clouds.add(new Point(i, j));
            }
        }
        return clouds;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAX = N * 25;

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        instructions = new Instruction[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            instructions[i] = new Instruction(d, s);
        }
    }

    private static final class Instruction {
        int d, s;

        Instruction(int d, int s) {
            this.d = d;
            this.s = s;
        }
    }

    private static final class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point p = (Point) obj;

                return this.x == p.x && this.y == p.y;
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return 100 * x + y;
        }
    }
}
